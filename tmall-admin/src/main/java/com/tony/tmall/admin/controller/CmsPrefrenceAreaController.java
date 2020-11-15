package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.CmsPrefrenceAreaEntity;
import com.tony.tmall.service.CmsPrefrenceAreaService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 优选专区
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("/prefrenceAre")
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public R listAll() {
        List<CmsPrefrenceAreaEntity> prefrenceAreaList = cmsPrefrenceAreaService.list();
        return R.ok(prefrenceAreaList);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation("分页获取商品优选")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsPrefrenceAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CmsPrefrenceAreaEntity cmsPrefrenceArea = cmsPrefrenceAreaService.getById(id);

        return R.ok().put("cmsPrefrenceArea", cmsPrefrenceArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CmsPrefrenceAreaEntity cmsPrefrenceArea){
		cmsPrefrenceAreaService.save(cmsPrefrenceArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CmsPrefrenceAreaEntity cmsPrefrenceArea){
		cmsPrefrenceAreaService.updateById(cmsPrefrenceArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		cmsPrefrenceAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
