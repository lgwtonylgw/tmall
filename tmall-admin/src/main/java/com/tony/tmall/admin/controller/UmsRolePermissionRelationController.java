package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsRolePermissionRelationEntity;
import com.tony.tmall.service.UmsRolePermissionRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 后台用户角色和权限关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsrolepermissionrelation")
public class UmsRolePermissionRelationController {
    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsrolepermissionrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRolePermissionRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsrolepermissionrelation:info")
    public R info(@PathVariable("id") Long id){
		UmsRolePermissionRelationEntity umsRolePermissionRelation = umsRolePermissionRelationService.getById(id);

        return R.ok().put("umsRolePermissionRelation", umsRolePermissionRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsrolepermissionrelation:save")
    public R save(@RequestBody UmsRolePermissionRelationEntity umsRolePermissionRelation){
		umsRolePermissionRelationService.save(umsRolePermissionRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsrolepermissionrelation:update")
    public R update(@RequestBody UmsRolePermissionRelationEntity umsRolePermissionRelation){
		umsRolePermissionRelationService.updateById(umsRolePermissionRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsrolepermissionrelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsRolePermissionRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
