package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.UmsResourceCategoryEntity;
import com.tony.tmall.service.UmsResourceCategoryService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 资源分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsresourcecategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsresourcecategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsResourceCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsresourcecategory:info")
    public R info(@PathVariable("id") Long id){
		UmsResourceCategoryEntity umsResourceCategory = umsResourceCategoryService.getById(id);

        return R.ok().put("umsResourceCategory", umsResourceCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsresourcecategory:save")
    public R save(@RequestBody UmsResourceCategoryEntity umsResourceCategory){
		umsResourceCategoryService.save(umsResourceCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsresourcecategory:update")
    public R update(@RequestBody UmsResourceCategoryEntity umsResourceCategory){
		umsResourceCategoryService.updateById(umsResourceCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsresourcecategory:delete")
    public R delete(@RequestBody Long[] ids){
		umsResourceCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
