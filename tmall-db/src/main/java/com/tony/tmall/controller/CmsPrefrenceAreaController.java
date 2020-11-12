package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.CmsPrefrenceAreaEntity;
import com.tony.tmall.service.CmsPrefrenceAreaService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 优选专区
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmsprefrencearea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmsprefrencearea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsPrefrenceAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmsprefrencearea:info")
    public R info(@PathVariable("id") Long id){
		CmsPrefrenceAreaEntity cmsPrefrenceArea = cmsPrefrenceAreaService.getById(id);

        return R.ok().put("cmsPrefrenceArea", cmsPrefrenceArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmsprefrencearea:save")
    public R save(@RequestBody CmsPrefrenceAreaEntity cmsPrefrenceArea){
		cmsPrefrenceAreaService.save(cmsPrefrenceArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmsprefrencearea:update")
    public R update(@RequestBody CmsPrefrenceAreaEntity cmsPrefrenceArea){
		cmsPrefrenceAreaService.updateById(cmsPrefrenceArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmsprefrencearea:delete")
    public R delete(@RequestBody Long[] ids){
		cmsPrefrenceAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
