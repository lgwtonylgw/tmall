package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.tony.tmall.service.SmsHomeRecommendProductService;
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
 * 人气推荐商品
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsHomeRecommendProductController", description = "首页人气推荐管理")
@RequestMapping("/home/recommendProduct")
public class SmsHomeRecommendProductController {
    @Autowired
    private SmsHomeRecommendProductService smsHomeRecommendProductService;


    @ApiOperation("添加首页推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody List<SmsHomeRecommendProductEntity> homeBrandList) {
        int count = smsHomeRecommendProductService.create(homeBrandList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateSort(@PathVariable Long id, Integer sort) {
        SmsHomeRecommendProductEntity recommendProduct = new SmsHomeRecommendProductEntity();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        boolean success = smsHomeRecommendProductService.updateById(recommendProduct);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除推荐")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = smsHomeRecommendProductService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public R updateRecommendStatus(@RequestParam("ids") List<Long> ids, @RequestParam Integer recommendStatus) {
        SmsHomeRecommendProductEntity record = new SmsHomeRecommendProductEntity();
        record.setRecommendStatus(recommendStatus);
        boolean success = smsHomeRecommendProductService.update(record,
                new LambdaQueryWrapper<SmsHomeRecommendProductEntity>()
                        .in(SmsHomeRecommendProductEntity::getId, ids));
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
        Page<SmsHomeRecommendProductEntity> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SmsHomeRecommendProductEntity> wrapper = new LambdaQueryWrapper<>();

        if (!StringUtils.isEmpty(productName)) {
            wrapper.like(SmsHomeRecommendProductEntity::getProductName, productName);
        }
        if (recommendStatus != null) {
            wrapper.eq(SmsHomeRecommendProductEntity::getRecommendStatus, recommendStatus);
        }
        Page<SmsHomeRecommendProductEntity> homeBrandList = smsHomeRecommendProductService.page(
                page, wrapper);
        return R.ok(homeBrandList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomerecommendproduct:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsHomeRecommendProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomerecommendproduct:info")
    public R info(@PathVariable("id") Long id) {
        SmsHomeRecommendProductEntity smsHomeRecommendProduct = smsHomeRecommendProductService.getById(id);

        return R.ok().put("smsHomeRecommendProduct", smsHomeRecommendProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomerecommendproduct:save")
    public R save(@RequestBody SmsHomeRecommendProductEntity smsHomeRecommendProduct) {
        smsHomeRecommendProductService.save(smsHomeRecommendProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomerecommendproduct:update")
    public R update(@RequestBody SmsHomeRecommendProductEntity smsHomeRecommendProduct) {
        smsHomeRecommendProductService.updateById(smsHomeRecommendProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomerecommendproduct:delete")
    public R delete(@RequestBody Long[] ids) {
        smsHomeRecommendProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
