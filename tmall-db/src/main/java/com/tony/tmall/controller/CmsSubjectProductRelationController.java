package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.CmsSubjectProductRelationEntity;
import com.tony.tmall.service.CmsSubjectProductRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 专题商品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmssubjectproductrelation")
public class CmsSubjectProductRelationController {
    @Autowired
    private CmsSubjectProductRelationService cmsSubjectProductRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmssubjectproductrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsSubjectProductRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmssubjectproductrelation:info")
    public R info(@PathVariable("id") Long id){
		CmsSubjectProductRelationEntity cmsSubjectProductRelation = cmsSubjectProductRelationService.getById(id);

        return R.ok().put("cmsSubjectProductRelation", cmsSubjectProductRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmssubjectproductrelation:save")
    public R save(@RequestBody CmsSubjectProductRelationEntity cmsSubjectProductRelation){
		cmsSubjectProductRelationService.save(cmsSubjectProductRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmssubjectproductrelation:update")
    public R update(@RequestBody CmsSubjectProductRelationEntity cmsSubjectProductRelation){
		cmsSubjectProductRelationService.updateById(cmsSubjectProductRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmssubjectproductrelation:delete")
    public R delete(@RequestBody Long[] ids){
		cmsSubjectProductRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
