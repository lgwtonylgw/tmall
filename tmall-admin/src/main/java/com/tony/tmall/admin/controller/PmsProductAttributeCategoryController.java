package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.model.vo.PmsProductAttributeCategoryItem;
import com.tony.tmall.service.PmsProductAttributeCategoryService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 产品属性分类
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestParam String name) {
        PmsProductAttributeCategoryEntity pmsProductAttributeCategoryEntity = new PmsProductAttributeCategoryEntity();
        pmsProductAttributeCategoryEntity.setName(name);
        boolean save = pmsProductAttributeCategoryService.save(pmsProductAttributeCategoryEntity);
        if (save) {
            return R.ok(save);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestParam String name) {
        PmsProductAttributeCategoryEntity pmsProductAttributeCategoryEntity = new PmsProductAttributeCategoryEntity();
        pmsProductAttributeCategoryEntity.setName(name);
        pmsProductAttributeCategoryEntity.setId(id);
        boolean success = pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategoryEntity);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        boolean success = pmsProductAttributeCategoryService.removeById(id);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("获取单个商品属性分类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        PmsProductAttributeCategoryEntity productAttributeCategory = pmsProductAttributeCategoryService.getById(id);
        return R.ok(productAttributeCategory);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        Page<PmsProductAttributeCategoryEntity> productAttributeCategoryList = pmsProductAttributeCategoryService.page(new Page<PmsProductAttributeCategoryEntity>(pageNum,pageSize));
        return R.ok(productAttributeCategoryList);
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public R getListWithAttr() {
        List<PmsProductAttributeCategoryItem> productAttributeCategoryResultList = pmsProductAttributeCategoryService.getListWithAttr();
        return R.ok(productAttributeCategoryResultList);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductAttributeCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PmsProductAttributeCategoryEntity pmsProductAttributeCategory = pmsProductAttributeCategoryService.getById(id);

        return R.ok().put("pmsProductAttributeCategory", pmsProductAttributeCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsProductAttributeCategoryEntity pmsProductAttributeCategory){
		pmsProductAttributeCategoryService.save(pmsProductAttributeCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsProductAttributeCategoryEntity pmsProductAttributeCategory){
		pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductAttributeCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
