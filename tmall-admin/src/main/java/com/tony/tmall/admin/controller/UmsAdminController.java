package com.tony.tmall.admin.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.model.dto.UmsAdminLoginParam;
import com.tony.tmall.admin.model.dto.UmsAdminParam;
import com.tony.tmall.admin.model.dto.UpdateAdminPasswordParam;
import com.tony.tmall.admin.service.AdminService;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.UmsAdminEntity;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.service.UmsAdminService;
import com.tony.tmall.service.UmsRoleService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 后台用户
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public R register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        UmsAdminEntity umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return R.ok(umsAdmin);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public R login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return R.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return R.ok(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public R refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return R.error("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return R.ok(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public R getAdminInfo(Principal principal) {
        if (principal == null) {
            return R.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdminEntity umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", umsRoleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRoleEntity> roleList = adminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRoleEntity::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return R.ok(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public R logout() {
        return R.ok(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "keyword", required = false) String keyword,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        Page<UmsAdminEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<UmsAdminEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(UmsAdminEntity::getUsername, keyword)
                    .or().like(UmsAdminEntity::getNickName, keyword);
        }
        Page<UmsAdminEntity> umsAdminEntityPage = umsAdminService.page(
                page, wrapper);
        return R.ok(umsAdminEntityPage);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        UmsAdminEntity admin = umsAdminService.getById(id);
        return R.ok(admin);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody UmsAdminEntity admin) {
        boolean success = adminService.update(id, admin);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public R updatePassword(@Validated @RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return R.ok(status);
        } else if (status == -1) {
            return R.error("提交参数不合法");
        } else if (status == -2) {
            return R.error("找不到该用户");
        } else if (status == -3) {
            return R.error("旧密码错误");
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = adminService.delete(id);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsAdminEntity umsAdmin = new UmsAdminEntity();
        umsAdmin.setStatus(status);
        boolean success = adminService.update(id, umsAdmin);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public R updateRole(@RequestParam("adminId") Long adminId,
                        @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public R getRoleList(@PathVariable Long adminId) {
        List<UmsRoleEntity> roleList = adminService.getRoleList(adminId);
        return R.ok(roleList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsadmin:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsAdminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsadmin:info")
    public R info(@PathVariable("id") Long id) {
        UmsAdminEntity umsAdmin = umsAdminService.getById(id);

        return R.ok().put("umsAdmin", umsAdmin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsadmin:save")
    public R save(@RequestBody UmsAdminEntity umsAdmin) {
        umsAdminService.save(umsAdmin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsadmin:update")
    public R update(@RequestBody UmsAdminEntity umsAdmin) {
        umsAdminService.updateById(umsAdmin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsadmin:delete")
    public R delete(@RequestBody Long[] ids) {
        umsAdminService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
