package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductCategoryAttributeRelationEntity;
import com.tony.tmall.service.PmsProductCategoryAttributeRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductcategoryattributerelation")
public class PmsProductCategoryAttributeRelationController {
    @Autowired
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductcategoryattributerelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductCategoryAttributeRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductcategoryattributerelation:info")
    public R info(@PathVariable("id") Long id){
		PmsProductCategoryAttributeRelationEntity pmsProductCategoryAttributeRelation = pmsProductCategoryAttributeRelationService.getById(id);

        return R.ok().put("pmsProductCategoryAttributeRelation", pmsProductCategoryAttributeRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductcategoryattributerelation:save")
    public R save(@RequestBody PmsProductCategoryAttributeRelationEntity pmsProductCategoryAttributeRelation){
		pmsProductCategoryAttributeRelationService.save(pmsProductCategoryAttributeRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductcategoryattributerelation:update")
    public R update(@RequestBody PmsProductCategoryAttributeRelationEntity pmsProductCategoryAttributeRelation){
		pmsProductCategoryAttributeRelationService.updateById(pmsProductCategoryAttributeRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductcategoryattributerelation:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductCategoryAttributeRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
