package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsRoleMenuRelationEntity;
import com.tony.tmall.service.UmsRoleMenuRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台角色菜单关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsrolemenurelation")
public class UmsRoleMenuRelationController {
    @Autowired
    private UmsRoleMenuRelationService umsRoleMenuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsrolemenurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRoleMenuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsrolemenurelation:info")
    public R info(@PathVariable("id") Long id){
		UmsRoleMenuRelationEntity umsRoleMenuRelation = umsRoleMenuRelationService.getById(id);

        return R.ok().put("umsRoleMenuRelation", umsRoleMenuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsrolemenurelation:save")
    public R save(@RequestBody UmsRoleMenuRelationEntity umsRoleMenuRelation){
		umsRoleMenuRelationService.save(umsRoleMenuRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsrolemenurelation:update")
    public R update(@RequestBody UmsRoleMenuRelationEntity umsRoleMenuRelation){
		umsRoleMenuRelationService.updateById(umsRoleMenuRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsrolemenurelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsRoleMenuRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
