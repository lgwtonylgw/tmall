package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.SmsCouponHistoryEntity;
import com.tony.tmall.service.SmsCouponHistoryService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 优惠券使用、领取历史
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsCouponHistoryController", description = "优惠券领取记录管理")
@RequestMapping("/couponHistory")
public class SmsCouponHistoryController {
    @Autowired
    private SmsCouponHistoryService smsCouponHistoryService;


    @ApiOperation("根据优惠券id，使用状态，订单编号分页获取领取记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "couponId", required = false) Long couponId,
                  @RequestParam(value = "useStatus", required = false) Integer useStatus,
                  @RequestParam(value = "orderSn", required = false) String orderSn,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SmsCouponHistoryEntity> page = new Page<SmsCouponHistoryEntity>(pageNum, pageSize);
        LambdaQueryWrapper<SmsCouponHistoryEntity> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(orderSn)){
            wrapper.eq(SmsCouponHistoryEntity::getOrderSn,orderSn);
        }
        if(useStatus!=null){
            wrapper.eq(SmsCouponHistoryEntity::getUseStatus,useStatus);
        }
        if(couponId!=null){
            wrapper.eq(SmsCouponHistoryEntity::getCouponId,couponId);
        }
        Page<SmsCouponHistoryEntity> historyList = smsCouponHistoryService.page(page,wrapper);
        return R.ok(historyList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smscouponhistory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsCouponHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smscouponhistory:info")
    public R info(@PathVariable("id") Long id) {
        SmsCouponHistoryEntity smsCouponHistory = smsCouponHistoryService.getById(id);

        return R.ok().put("smsCouponHistory", smsCouponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smscouponhistory:save")
    public R save(@RequestBody SmsCouponHistoryEntity smsCouponHistory) {
        smsCouponHistoryService.save(smsCouponHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smscouponhistory:update")
    public R update(@RequestBody SmsCouponHistoryEntity smsCouponHistory) {
        smsCouponHistoryService.updateById(smsCouponHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smscouponhistory:delete")
    public R delete(@RequestBody Long[] ids) {
        smsCouponHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
