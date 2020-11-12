package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsPermissionEntity;
import com.tony.tmall.service.UmsPermissionService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台用户权限表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umspermission")
public class UmsPermissionController {
    @Autowired
    private UmsPermissionService umsPermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umspermission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsPermissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umspermission:info")
    public R info(@PathVariable("id") Long id){
		UmsPermissionEntity umsPermission = umsPermissionService.getById(id);

        return R.ok().put("umsPermission", umsPermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umspermission:save")
    public R save(@RequestBody UmsPermissionEntity umsPermission){
		umsPermissionService.save(umsPermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umspermission:update")
    public R update(@RequestBody UmsPermissionEntity umsPermission){
		umsPermissionService.updateById(umsPermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umspermission:delete")
    public R delete(@RequestBody Long[] ids){
		umsPermissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
