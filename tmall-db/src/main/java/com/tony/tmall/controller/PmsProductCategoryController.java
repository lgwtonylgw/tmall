package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductCategoryEntity;
import com.tony.tmall.service.PmsProductCategoryService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 产品分类
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductcategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductcategory:info")
    public R info(@PathVariable("id") Long id){
		PmsProductCategoryEntity pmsProductCategory = pmsProductCategoryService.getById(id);

        return R.ok().put("pmsProductCategory", pmsProductCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductcategory:save")
    public R save(@RequestBody PmsProductCategoryEntity pmsProductCategory){
		pmsProductCategoryService.save(pmsProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductcategory:update")
    public R update(@RequestBody PmsProductCategoryEntity pmsProductCategory){
		pmsProductCategoryService.updateById(pmsProductCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductcategory:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
