package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsAdminRoleRelationEntity;
import com.tony.tmall.service.UmsAdminRoleRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 后台用户和角色关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsadminrolerelation")
public class UmsAdminRoleRelationController {
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsadminrolerelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsAdminRoleRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsadminrolerelation:info")
    public R info(@PathVariable("id") Long id){
		UmsAdminRoleRelationEntity umsAdminRoleRelation = umsAdminRoleRelationService.getById(id);

        return R.ok().put("umsAdminRoleRelation", umsAdminRoleRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsadminrolerelation:save")
    public R save(@RequestBody UmsAdminRoleRelationEntity umsAdminRoleRelation){
		umsAdminRoleRelationService.save(umsAdminRoleRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsadminrolerelation:update")
    public R update(@RequestBody UmsAdminRoleRelationEntity umsAdminRoleRelation){
		umsAdminRoleRelationService.updateById(umsAdminRoleRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsadminrolerelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsAdminRoleRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
