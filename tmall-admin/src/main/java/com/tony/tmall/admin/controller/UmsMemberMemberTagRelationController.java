package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsMemberMemberTagRelationEntity;
import com.tony.tmall.service.UmsMemberMemberTagRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 用户和标签关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmembermembertagrelation")
public class UmsMemberMemberTagRelationController {
    @Autowired
    private UmsMemberMemberTagRelationService umsMemberMemberTagRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmembermembertagrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberMemberTagRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmembermembertagrelation:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberMemberTagRelationEntity umsMemberMemberTagRelation = umsMemberMemberTagRelationService.getById(id);

        return R.ok().put("umsMemberMemberTagRelation", umsMemberMemberTagRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmembermembertagrelation:save")
    public R save(@RequestBody UmsMemberMemberTagRelationEntity umsMemberMemberTagRelation){
		umsMemberMemberTagRelationService.save(umsMemberMemberTagRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmembermembertagrelation:update")
    public R update(@RequestBody UmsMemberMemberTagRelationEntity umsMemberMemberTagRelation){
		umsMemberMemberTagRelationService.updateById(umsMemberMemberTagRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmembermembertagrelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberMemberTagRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
