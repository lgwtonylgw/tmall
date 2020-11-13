package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsSubjectCategoryEntity;
import com.tony.tmall.service.CmsSubjectCategoryService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 专题分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmssubjectcategory")
public class CmsSubjectCategoryController {
    @Autowired
    private CmsSubjectCategoryService cmsSubjectCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmssubjectcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsSubjectCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmssubjectcategory:info")
    public R info(@PathVariable("id") Long id){
		CmsSubjectCategoryEntity cmsSubjectCategory = cmsSubjectCategoryService.getById(id);

        return R.ok().put("cmsSubjectCategory", cmsSubjectCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmssubjectcategory:save")
    public R save(@RequestBody CmsSubjectCategoryEntity cmsSubjectCategory){
		cmsSubjectCategoryService.save(cmsSubjectCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmssubjectcategory:update")
    public R update(@RequestBody CmsSubjectCategoryEntity cmsSubjectCategory){
		cmsSubjectCategoryService.updateById(cmsSubjectCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmssubjectcategory:delete")
    public R delete(@RequestBody Long[] ids){
		cmsSubjectCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
