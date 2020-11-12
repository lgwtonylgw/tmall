package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsRoleResourceRelationEntity;
import com.tony.tmall.service.UmsRoleResourceRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 后台角色资源关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsroleresourcerelation")
public class UmsRoleResourceRelationController {
    @Autowired
    private UmsRoleResourceRelationService umsRoleResourceRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsroleresourcerelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsRoleResourceRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsroleresourcerelation:info")
    public R info(@PathVariable("id") Long id){
		UmsRoleResourceRelationEntity umsRoleResourceRelation = umsRoleResourceRelationService.getById(id);

        return R.ok().put("umsRoleResourceRelation", umsRoleResourceRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsroleresourcerelation:save")
    public R save(@RequestBody UmsRoleResourceRelationEntity umsRoleResourceRelation){
		umsRoleResourceRelationService.save(umsRoleResourceRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsroleresourcerelation:update")
    public R update(@RequestBody UmsRoleResourceRelationEntity umsRoleResourceRelation){
		umsRoleResourceRelationService.updateById(umsRoleResourceRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsroleresourcerelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsRoleResourceRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
