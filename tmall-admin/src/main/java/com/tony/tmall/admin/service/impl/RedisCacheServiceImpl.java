package com.tony.tmall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.admin.service.RedisCacheService;
import com.tony.tmall.common.utils.RedisUtil;
import com.tony.tmall.dao.UmsAdminRoleRelationDao;
import com.tony.tmall.entity.UmsAdminEntity;
import com.tony.tmall.entity.UmsAdminRoleRelationEntity;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.service.UmsAdminRoleRelationService;
import com.tony.tmall.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Author: tony
 * Date: 2020/11/15 17:06
 * Description:
 */
@Service
@Slf4j
public class RedisCacheServiceImpl implements RedisCacheService {
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delAdmin(Long adminId) {
        UmsAdminEntity admin = umsAdminService.getById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisUtil.delete(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisUtil.delete(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        List<UmsAdminRoleRelationEntity> relationList = umsAdminRoleRelationService.list(new LambdaQueryWrapper<UmsAdminRoleRelationEntity>()
                .eq(UmsAdminRoleRelationEntity::getRoleId, roleId));
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisUtil.delete(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        List<UmsAdminRoleRelationEntity> relationList = umsAdminRoleRelationService.list(new LambdaQueryWrapper<UmsAdminRoleRelationEntity>()
                .in(UmsAdminRoleRelationEntity::getRoleId, roleIds));
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisUtil.delete(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> adminIdList = umsAdminRoleRelationDao.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisUtil.delete(keys);
        }
    }

    @Override
    public UmsAdminEntity getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdminEntity) redisUtil.get(key);
    }

    @Override
    public void setAdmin(UmsAdminEntity admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisUtil.setEx(key, admin, REDIS_EXPIRE, TimeUnit.SECONDS);
    }

    @Override
    public List<UmsResourceEntity> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResourceEntity>) redisUtil.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResourceEntity> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisUtil.setEx(key, resourceList, REDIS_EXPIRE, TimeUnit.SECONDS);
    }
}
