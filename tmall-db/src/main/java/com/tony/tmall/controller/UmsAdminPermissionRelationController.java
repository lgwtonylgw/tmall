package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsAdminPermissionRelationEntity;
import com.tony.tmall.service.UmsAdminPermissionRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsadminpermissionrelation")
public class UmsAdminPermissionRelationController {
    @Autowired
    private UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsadminpermissionrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsAdminPermissionRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsadminpermissionrelation:info")
    public R info(@PathVariable("id") Long id){
		UmsAdminPermissionRelationEntity umsAdminPermissionRelation = umsAdminPermissionRelationService.getById(id);

        return R.ok().put("umsAdminPermissionRelation", umsAdminPermissionRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsadminpermissionrelation:save")
    public R save(@RequestBody UmsAdminPermissionRelationEntity umsAdminPermissionRelation){
		umsAdminPermissionRelationService.save(umsAdminPermissionRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsadminpermissionrelation:update")
    public R update(@RequestBody UmsAdminPermissionRelationEntity umsAdminPermissionRelation){
		umsAdminPermissionRelationService.updateById(umsAdminPermissionRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsadminpermissionrelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsAdminPermissionRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
