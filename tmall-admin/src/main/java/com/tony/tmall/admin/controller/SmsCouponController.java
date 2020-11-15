package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsCouponEntity;
import com.tony.tmall.model.dto.SmsCouponParam;
import com.tony.tmall.service.SmsCouponService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsCouponController", description = "优惠券管理")
@RequestMapping("/coupon")
public class SmsCouponController {
    @Autowired
    private SmsCouponService smsCouponService;

    @ApiOperation("添加优惠券")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R add(@RequestBody SmsCouponParam couponParam) {
        int count = smsCouponService.create(couponParam);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("删除优惠券")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@PathVariable Long id) {
        int count = smsCouponService.delete(id);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改优惠券")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody SmsCouponParam couponParam) {
        int count = smsCouponService.updateByid(id, couponParam);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        Page<SmsCouponEntity> page = new Page<SmsCouponEntity>(pageNum, pageSize);
        LambdaQueryWrapper<SmsCouponEntity> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            wrapper.like(SmsCouponEntity::getName,name);
        }
        if(type!=null){
            wrapper.eq(SmsCouponEntity::getType,type);
        }
        Page<SmsCouponEntity> couponList = smsCouponService.page(page,wrapper);
        return R.ok(couponList);
    }

    @ApiOperation("获取单个优惠券的详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        SmsCouponParam couponParam = smsCouponService.getItem(id);
        return R.ok(couponParam);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smscoupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsCouponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smscoupon:info")
    public R info(@PathVariable("id") Long id) {
        SmsCouponEntity smsCoupon = smsCouponService.getById(id);

        return R.ok().put("smsCoupon", smsCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smscoupon:save")
    public R save(@RequestBody SmsCouponEntity smsCoupon) {
        smsCouponService.save(smsCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smscoupon:update")
    public R update(@RequestBody SmsCouponEntity smsCoupon) {
        smsCouponService.updateById(smsCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smscoupon:delete")
    public R delete(@RequestBody Long[] ids) {
        smsCouponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
