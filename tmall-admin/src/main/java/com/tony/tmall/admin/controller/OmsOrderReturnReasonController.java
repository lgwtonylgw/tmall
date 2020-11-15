package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.OmsOrderReturnReasonEntity;
import com.tony.tmall.service.OmsOrderReturnReasonService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 退货原因
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService omsOrderReturnReasonService;


    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody OmsOrderReturnReasonEntity returnReason) {
        returnReason.setCreateTime(new Date());
        boolean success = omsOrderReturnReasonService.save(returnReason);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改退货原因")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody OmsOrderReturnReasonEntity returnReason) {
        returnReason.setId(id);
        Boolean success = omsOrderReturnReasonService.updateById(returnReason);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("批量删除退货原因")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = omsOrderReturnReasonService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询全部退货原因")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<OmsOrderReturnReasonEntity> page = new Page<>(pageNum, pageSize);
        IPage<OmsOrderReturnReasonEntity> result = omsOrderReturnReasonService.page(page);
        return R.ok(result);
    }

    @ApiOperation("获取单个退货原因详情信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        OmsOrderReturnReasonEntity reason = omsOrderReturnReasonService.getById(id);
        return R.ok(reason);
    }

    @ApiOperation("修改退货原因启用状态")
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@RequestParam(value = "status") Integer status,
                          @RequestParam("ids") List<Long> ids) {
        int count = omsOrderReturnReasonService.updateStatus(ids, status);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderReturnReasonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        OmsOrderReturnReasonEntity omsOrderReturnReason = omsOrderReturnReasonService.getById(id);

        return R.ok().put("omsOrderReturnReason", omsOrderReturnReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OmsOrderReturnReasonEntity omsOrderReturnReason) {
        omsOrderReturnReasonService.save(omsOrderReturnReason);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OmsOrderReturnReasonEntity omsOrderReturnReason) {
        omsOrderReturnReasonService.updateById(omsOrderReturnReason);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        omsOrderReturnReasonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
