package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.service.RedisCacheService;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.service.UmsRoleService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 后台用户角色
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;
    @Autowired
    private RedisCacheService redisCacheService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody UmsRoleEntity role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        boolean success = umsRoleService.save(role);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody UmsRoleEntity role) {
        role.setId(id);
        boolean success = umsRoleService.updateById(role);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = umsRoleService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R listAll() {
        List<UmsRoleEntity> roleList = umsRoleService.list();
        return R.ok(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "keyword", required = false) String keyword,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {


        Page<UmsRoleEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<UmsRoleEntity> wrapper = new LambdaQueryWrapper<>();
        
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(UmsRoleEntity::getName, keyword);
        }

        Page<UmsRoleEntity> umsRoleEntityPage = umsRoleService.page(
                page, wrapper);
        return R.ok(umsRoleEntityPage);
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRoleEntity umsRole = new UmsRoleEntity();
        umsRole.setStatus(status);
        umsRole.setId(id);
        boolean success = umsRoleService.updateById(umsRole);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public R listMenu(@PathVariable Long roleId) {
        List<UmsMenuEntity> roleList = umsRoleService.listMenu(roleId);
        return R.ok(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public R listResource(@PathVariable Long roleId) {
        List<UmsResourceEntity> roleList = umsRoleService.listResource(roleId);
        return R.ok(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public R allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = umsRoleService.allocMenu(roleId, menuIds);
        return R.ok(count);
    }

    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ResponseBody
    public R allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = umsRoleService.allocResource(roleId, resourceIds);
        redisCacheService.delResourceListByRole(roleId);
        return R.ok(count);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsrole:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsrole:info")
    public R info(@PathVariable("id") Long id) {
        UmsRoleEntity umsRole = umsRoleService.getById(id);

        return R.ok().put("umsRole", umsRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsrole:save")
    public R save(@RequestBody UmsRoleEntity umsRole) {
        umsRoleService.save(umsRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsrole:update")
    public R update(@RequestBody UmsRoleEntity umsRole) {
        umsRoleService.updateById(umsRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsrole:delete")
    public R delete(@RequestBody Long[] ids) {
        umsRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
