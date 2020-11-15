package com.tony.tmall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.admin.model.bean.AdminUserDetails;
import com.tony.tmall.admin.model.dto.UmsAdminParam;
import com.tony.tmall.admin.model.dto.UpdateAdminPasswordParam;
import com.tony.tmall.admin.service.AdminService;
import com.tony.tmall.admin.service.RedisCacheService;
import com.tony.tmall.common.exception.ApiException;
import com.tony.tmall.common.utils.RequestUtil;
import com.tony.tmall.dao.UmsAdminRoleRelationDao;
import com.tony.tmall.entity.*;
import com.tony.tmall.security.util.JwtTokenUtil;
import com.tony.tmall.service.UmsAdminLoginLogService;
import com.tony.tmall.service.UmsAdminRoleRelationService;
import com.tony.tmall.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: tony
 * Date: 2020/11/15 17:03
 * Description:
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsAdminLoginLogService umsAdminLoginLogService;

    @Override
    public UmsAdminEntity register(UmsAdminParam umsAdminParam) {
        UmsAdminEntity umsAdmin = new UmsAdminEntity();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdminEntity> umsAdminList = umsAdminService.list(
                new LambdaQueryWrapper<UmsAdminEntity>()
                        .eq(UmsAdminEntity::getUsername, umsAdmin.getUsername())
        );
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminService.save(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new ApiException("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                throw new ApiException("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage(), e);
        }
        return token;
    }

    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdminEntity admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResourceEntity> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public UmsAdminEntity getAdminByUsername(String username) {
        UmsAdminEntity admin = redisCacheService.getAdmin(username);
        if (admin != null) return admin;
        List<UmsAdminEntity> adminList = umsAdminService.list(new LambdaQueryWrapper<UmsAdminEntity>()
                .eq(UmsAdminEntity::getUsername, username));
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            redisCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }


    public List<UmsResourceEntity> getResourceList(Long adminId) {
        List<UmsResourceEntity> resourceList = redisCacheService.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        resourceList = umsAdminRoleRelationDao.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            redisCacheService.setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdminEntity admin = getAdminByUsername(username);
        if (admin == null) return;
        UmsAdminLoginLogEntity loginLog = new UmsAdminLoginLogEntity();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        umsAdminLoginLogService.save(loginLog);
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public List<UmsRoleEntity> getRoleList(Long adminId) {
        return umsAdminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public boolean update(Long id, UmsAdminEntity admin) {
        admin.setId(id);
        UmsAdminEntity rawAdmin = umsAdminService.getById(id);
        if (rawAdmin.getPassword().equals(admin.getPassword())) {
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        } else {
            //与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(admin.getPassword())) {
                admin.setPassword(null);
            } else {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        boolean success = umsAdminService.updateById(admin);
        redisCacheService.delAdmin(id);
        return success;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if (StrUtil.isEmpty(param.getUsername())
                || StrUtil.isEmpty(param.getOldPassword())
                || StrUtil.isEmpty(param.getNewPassword())) {
            return -1;
        }
        List<UmsAdminEntity> adminList = umsAdminService.list(new LambdaQueryWrapper<UmsAdminEntity>()
                .eq(UmsAdminEntity::getUsername, param.getUsername()));
        if (CollUtil.isEmpty(adminList)) {
            return -2;
        }
        UmsAdminEntity umsAdmin = adminList.get(0);
        if (!passwordEncoder.matches(param.getOldPassword(), umsAdmin.getPassword())) {
            return -3;
        }
        umsAdmin.setPassword(passwordEncoder.encode(param.getNewPassword()));
        umsAdminService.updateById(umsAdmin);
        redisCacheService.delAdmin(umsAdmin.getId());
        return 1;
    }


    @Override
    public boolean delete(Long id) {
        redisCacheService.delAdmin(id);
        boolean success = umsAdminService.removeById(id);
        redisCacheService.delResourceList(id);
        return success;
    }

    @Override
    @Transactional
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        umsAdminRoleRelationDao.delete(new LambdaQueryWrapper<UmsAdminRoleRelationEntity>()
                .eq(UmsAdminRoleRelationEntity::getAdminId, adminId));
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelationEntity> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelationEntity roleRelation = new UmsAdminRoleRelationEntity();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            umsAdminRoleRelationService.saveBatch(list);
        }
        redisCacheService.delResourceList(adminId);
        return count;
    }
}
