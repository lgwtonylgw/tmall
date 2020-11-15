package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.model.vo.ProductAttrInfo;
import com.tony.tmall.common.model.domain.CommonResult;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.tony.tmall.model.dto.PmsProductAttributeParam;
import com.tony.tmall.service.PmsProductAttributeService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品属性参数
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;


    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@PathVariable Long cid,
                     @RequestParam(value = "type") Integer type,
                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsProductAttributeEntity> page = new Page<>(pageNum, pageSize);

        Page<PmsProductAttributeEntity> productAttributeList = pmsProductAttributeService.page(page,
                new LambdaQueryWrapper<PmsProductAttributeEntity>().eq(PmsProductAttributeEntity::getProductAttributeCategoryId, cid)
                        .eq(PmsProductAttributeEntity::getType, type));
        return R.ok(productAttributeList);
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody PmsProductAttributeParam productAttributeParam) {
        int count = pmsProductAttributeService.create(productAttributeParam);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody PmsProductAttributeParam productAttributeParam) {
        PmsProductAttributeEntity pmsProductAttribute = new PmsProductAttributeEntity();
        pmsProductAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam, pmsProductAttribute);
        boolean success = pmsProductAttributeService.updateById(pmsProductAttribute);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        PmsProductAttributeEntity productAttribute = pmsProductAttributeService.getById(id);
        return R.ok(productAttribute);
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        int count = pmsProductAttributeService.delete(ids);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId) {
        List<ProductAttrInfo> productAttrInfoList = pmsProductAttributeService.getProductAttrInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsProductAttributeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        PmsProductAttributeEntity pmsProductAttribute = pmsProductAttributeService.getById(id);

        return R.ok().put("pmsProductAttribute", pmsProductAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsProductAttributeEntity pmsProductAttribute) {
        pmsProductAttributeService.save(pmsProductAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsProductAttributeEntity pmsProductAttribute) {
        pmsProductAttributeService.updateById(pmsProductAttribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        pmsProductAttributeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
