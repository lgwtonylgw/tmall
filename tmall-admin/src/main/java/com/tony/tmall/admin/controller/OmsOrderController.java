package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.model.dto.OmsMoneyInfoParam;
import com.tony.tmall.admin.model.dto.OmsOrderQueryParam;
import com.tony.tmall.admin.model.dto.OmsReceiverInfoParam;
import com.tony.tmall.admin.service.OrderService;
import com.tony.tmall.common.model.domain.CommonResult;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.OmsOrderEntity;
import com.tony.tmall.model.dto.OmsOrderDeliveryParam;
import com.tony.tmall.model.vo.OmsOrderDetail;
import com.tony.tmall.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 订单表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @Autowired
    private OrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(OmsOrderQueryParam queryParam,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<OmsOrderEntity> page = new Page<>(pageNum, pageSize);
        OmsOrderEntity omsOrderEntity = new OmsOrderEntity();
        BeanUtils.copyProperties(queryParam, omsOrderEntity);
        Page<OmsOrderEntity> orderList = omsOrderService.page(page, new QueryWrapper<OmsOrderEntity>(omsOrderEntity));
        return R.ok(orderList);
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public R delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public R close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids, note);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public R updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public R updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public R updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id, note, status);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:omsorder:info")
    public R info(@PathVariable("id") Long id) {
        OmsOrderEntity omsOrder = omsOrderService.getById(id);

        return R.ok().put("omsOrder", omsOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:omsorder:save")
    public R save(@RequestBody OmsOrderEntity omsOrder) {
        omsOrderService.save(omsOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:omsorder:update")
    public R update(@RequestBody OmsOrderEntity omsOrder) {
        omsOrderService.updateById(omsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:omsorder:delete")
    public R delete(@RequestBody Long[] ids) {
        omsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
