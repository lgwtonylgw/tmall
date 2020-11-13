package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsPrefrenceAreaProductRelationEntity;
import com.tony.tmall.service.CmsPrefrenceAreaProductRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 优选专区和产品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmsprefrenceareaproductrelation")
public class CmsPrefrenceAreaProductRelationController {
    @Autowired
    private CmsPrefrenceAreaProductRelationService cmsPrefrenceAreaProductRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmsprefrenceareaproductrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsPrefrenceAreaProductRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmsprefrenceareaproductrelation:info")
    public R info(@PathVariable("id") Long id){
		CmsPrefrenceAreaProductRelationEntity cmsPrefrenceAreaProductRelation = cmsPrefrenceAreaProductRelationService.getById(id);

        return R.ok().put("cmsPrefrenceAreaProductRelation", cmsPrefrenceAreaProductRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmsprefrenceareaproductrelation:save")
    public R save(@RequestBody CmsPrefrenceAreaProductRelationEntity cmsPrefrenceAreaProductRelation){
		cmsPrefrenceAreaProductRelationService.save(cmsPrefrenceAreaProductRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmsprefrenceareaproductrelation:update")
    public R update(@RequestBody CmsPrefrenceAreaProductRelationEntity cmsPrefrenceAreaProductRelation){
		cmsPrefrenceAreaProductRelationService.updateById(cmsPrefrenceAreaProductRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmsprefrenceareaproductrelation:delete")
    public R delete(@RequestBody Long[] ids){
		cmsPrefrenceAreaProductRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
