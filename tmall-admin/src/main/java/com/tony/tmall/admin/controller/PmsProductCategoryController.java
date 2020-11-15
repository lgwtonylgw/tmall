package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.model.dto.PmsProductCategoryParam;
import com.tony.tmall.model.vo.PmsProductCategoryWithChildrenItem;
import com.tony.tmall.common.model.domain.CommonResult;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsProductCategoryEntity;
import com.tony.tmall.service.PmsProductCategoryService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 产品分类
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation("添加产品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@Validated @RequestBody PmsProductCategoryParam productCategoryParam) {
        int count = pmsProductCategoryService.create(productCategoryParam);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id,
                    @Validated
                    @RequestBody PmsProductCategoryParam productCategoryParam) {
        int count = pmsProductCategoryService.updates(id, productCategoryParam);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@PathVariable Long parentId,
                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<PmsProductCategoryEntity> productCategoryList = pmsProductCategoryService.page(
                new Page<PmsProductCategoryEntity>(pageNum, pageSize),
                new LambdaQueryWrapper<PmsProductCategoryEntity>().eq(PmsProductCategoryEntity::getParentId, parentId));
        return R.ok(productCategoryList);
    }

    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        PmsProductCategoryEntity productCategory = pmsProductCategoryService.getById(id);
        return R.ok(productCategory);
    }

    @ApiOperation("删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        Boolean success = pmsProductCategoryService.removeById(id);
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateNavStatus(@RequestParam("ids") List<Long> ids, @RequestParam("navStatus") Integer navStatus) {
        PmsProductCategoryEntity productCategory = new PmsProductCategoryEntity();
        productCategory.setNavStatus(navStatus);
        boolean success = pmsProductCategoryService.update(productCategory,
                new LambdaQueryWrapper<PmsProductCategoryEntity>().in(PmsProductCategoryEntity::getId,ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        PmsProductCategoryEntity productCategory = new PmsProductCategoryEntity();
        productCategory.setShowStatus(showStatus);
        boolean success = pmsProductCategoryService.update(productCategory,
                new LambdaQueryWrapper<PmsProductCategoryEntity>().in(PmsProductCategoryEntity::getId,ids));
        if (success) {
            return R.ok(success);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = pmsProductCategoryService.listWithChildren();
        return CommonResult.success(list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductcategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsProductCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductcategory:info")
    public R info(@PathVariable("id") Long id) {
        PmsProductCategoryEntity pmsProductCategory = pmsProductCategoryService.getById(id);

        return R.ok().put("pmsProductCategory", pmsProductCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductcategory:save")
    public R save(@RequestBody PmsProductCategoryEntity pmsProductCategory) {
        pmsProductCategoryService.save(pmsProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductcategory:update")
    public R update(@RequestBody PmsProductCategoryEntity pmsProductCategory) {
        pmsProductCategoryService.updateById(pmsProductCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductcategory:delete")
    public R delete(@RequestBody Long[] ids) {
        pmsProductCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
