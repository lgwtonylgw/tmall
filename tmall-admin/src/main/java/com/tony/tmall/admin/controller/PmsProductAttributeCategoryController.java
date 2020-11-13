package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.service.PmsProductAttributeCategoryService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 产品属性分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductattributecategory")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductattributecategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductAttributeCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductattributecategory:info")
    public R info(@PathVariable("id") Long id){
		PmsProductAttributeCategoryEntity pmsProductAttributeCategory = pmsProductAttributeCategoryService.getById(id);

        return R.ok().put("pmsProductAttributeCategory", pmsProductAttributeCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductattributecategory:save")
    public R save(@RequestBody PmsProductAttributeCategoryEntity pmsProductAttributeCategory){
		pmsProductAttributeCategoryService.save(pmsProductAttributeCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductattributecategory:update")
    public R update(@RequestBody PmsProductAttributeCategoryEntity pmsProductAttributeCategory){
		pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductattributecategory:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductAttributeCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
