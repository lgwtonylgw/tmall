package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsHelpCategoryEntity;
import com.tony.tmall.service.CmsHelpCategoryService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 帮助分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmshelpcategory")
public class CmsHelpCategoryController {
    @Autowired
    private CmsHelpCategoryService cmsHelpCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsHelpCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CmsHelpCategoryEntity cmsHelpCategory = cmsHelpCategoryService.getById(id);

        return R.ok().put("cmsHelpCategory", cmsHelpCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CmsHelpCategoryEntity cmsHelpCategory){
		cmsHelpCategoryService.save(cmsHelpCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CmsHelpCategoryEntity cmsHelpCategory){
		cmsHelpCategoryService.updateById(cmsHelpCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		cmsHelpCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
