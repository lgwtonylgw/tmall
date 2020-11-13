package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsAdminEntity;
import com.tony.tmall.service.UmsAdminService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 后台用户表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsadmin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsadmin:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsAdminService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsadmin:info")
    public R info(@PathVariable("id") Long id){
		UmsAdminEntity umsAdmin = umsAdminService.getById(id);

        return R.ok().put("umsAdmin", umsAdmin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsadmin:save")
    public R save(@RequestBody UmsAdminEntity umsAdmin){
		umsAdminService.save(umsAdmin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsadmin:update")
    public R update(@RequestBody UmsAdminEntity umsAdmin){
		umsAdminService.updateById(umsAdmin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsadmin:delete")
    public R delete(@RequestBody Long[] ids){
		umsAdminService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
