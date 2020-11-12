package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsMemberProductCategoryRelationEntity;
import com.tony.tmall.service.UmsMemberProductCategoryRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 会员与产品分类关系表（用户喜欢的分类）
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmemberproductcategoryrelation")
public class UmsMemberProductCategoryRelationController {
    @Autowired
    private UmsMemberProductCategoryRelationService umsMemberProductCategoryRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmemberproductcategoryrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberProductCategoryRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmemberproductcategoryrelation:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberProductCategoryRelationEntity umsMemberProductCategoryRelation = umsMemberProductCategoryRelationService.getById(id);

        return R.ok().put("umsMemberProductCategoryRelation", umsMemberProductCategoryRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmemberproductcategoryrelation:save")
    public R save(@RequestBody UmsMemberProductCategoryRelationEntity umsMemberProductCategoryRelation){
		umsMemberProductCategoryRelationService.save(umsMemberProductCategoryRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmemberproductcategoryrelation:update")
    public R update(@RequestBody UmsMemberProductCategoryRelationEntity umsMemberProductCategoryRelation){
		umsMemberProductCategoryRelationService.updateById(umsMemberProductCategoryRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmemberproductcategoryrelation:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberProductCategoryRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
