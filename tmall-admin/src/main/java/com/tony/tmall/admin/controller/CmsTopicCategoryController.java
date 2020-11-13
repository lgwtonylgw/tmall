package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsTopicCategoryEntity;
import com.tony.tmall.service.CmsTopicCategoryService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 话题分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmstopiccategory")
public class CmsTopicCategoryController {
    @Autowired
    private CmsTopicCategoryService cmsTopicCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmstopiccategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsTopicCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmstopiccategory:info")
    public R info(@PathVariable("id") Long id){
		CmsTopicCategoryEntity cmsTopicCategory = cmsTopicCategoryService.getById(id);

        return R.ok().put("cmsTopicCategory", cmsTopicCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmstopiccategory:save")
    public R save(@RequestBody CmsTopicCategoryEntity cmsTopicCategory){
		cmsTopicCategoryService.save(cmsTopicCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmstopiccategory:update")
    public R update(@RequestBody CmsTopicCategoryEntity cmsTopicCategory){
		cmsTopicCategoryService.updateById(cmsTopicCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmstopiccategory:delete")
    public R delete(@RequestBody Long[] ids){
		cmsTopicCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
