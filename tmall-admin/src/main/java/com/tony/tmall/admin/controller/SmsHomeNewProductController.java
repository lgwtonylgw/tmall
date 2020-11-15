package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsHomeNewProductEntity;
import com.tony.tmall.service.SmsHomeNewProductService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 新鲜好物
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsHomeNewProductController", description = "首页新品管理")
@RequestMapping("/home/newProduct")
public class SmsHomeNewProductController {
    @Autowired
    private SmsHomeNewProductService smsHomeNewProductService;


    @ApiOperation("添加首页推荐品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody List<SmsHomeNewProductEntity> homeBrandList) {
        int count = smsHomeNewProductService.create(homeBrandList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateSort(@PathVariable Long id, Integer sort) {
        SmsHomeNewProductEntity homeNewProduct = new SmsHomeNewProductEntity();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        boolean success = smsHomeNewProductService.updateById(homeNewProduct);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = smsHomeNewProductService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        SmsHomeNewProductEntity record = new SmsHomeNewProductEntity();
        record.setRecommendStatus(recommendStatus);
        boolean success = smsHomeNewProductService.update(record,
                new LambdaQueryWrapper<SmsHomeNewProductEntity>().in(SmsHomeNewProductEntity::getId));
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "productName", required = false) String productName,
                  @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        Page<SmsHomeNewProductEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SmsHomeNewProductEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(productName)) {
            wrapper.like(SmsHomeNewProductEntity::getProductName, productName);
        }
        if (recommendStatus != null) {
            wrapper.eq(SmsHomeNewProductEntity::getRecommendStatus, recommendStatus);
        }
        Page<SmsHomeNewProductEntity> homeBrandList = smsHomeNewProductService.page(
                page, wrapper);
        return R.ok(homeBrandList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomenewproduct:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsHomeNewProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomenewproduct:info")
    public R info(@PathVariable("id") Long id) {
        SmsHomeNewProductEntity smsHomeNewProduct = smsHomeNewProductService.getById(id);

        return R.ok().put("smsHomeNewProduct", smsHomeNewProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomenewproduct:save")
    public R save(@RequestBody SmsHomeNewProductEntity smsHomeNewProduct) {
        smsHomeNewProductService.save(smsHomeNewProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomenewproduct:update")
    public R update(@RequestBody SmsHomeNewProductEntity smsHomeNewProduct) {
        smsHomeNewProductService.updateById(smsHomeNewProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomenewproduct:delete")
    public R delete(@RequestBody Long[] ids) {
        smsHomeNewProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
