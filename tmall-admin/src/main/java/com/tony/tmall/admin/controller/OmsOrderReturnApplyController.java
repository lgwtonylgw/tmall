package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.admin.model.dto.OmsReturnApplyQueryParam;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.OmsOrderReturnApplyEntity;
import com.tony.tmall.model.dto.OmsUpdateStatusParam;
import com.tony.tmall.model.vo.OmsOrderReturnApplyResult;
import com.tony.tmall.service.OmsOrderReturnApplyService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 订单退货申请
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;


    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(OmsReturnApplyQueryParam queryParam,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<OmsOrderReturnApplyEntity> page = new Page<>(pageNum, pageSize);
        OmsOrderReturnApplyEntity omsOrderReturnApplyEntity = new OmsOrderReturnApplyEntity();
        BeanUtils.copyProperties(queryParam, omsOrderReturnApplyEntity);
        Page<OmsOrderReturnApplyEntity> orderReturnApplyList = omsOrderReturnApplyService.page(page, new QueryWrapper<OmsOrderReturnApplyEntity>(omsOrderReturnApplyEntity));
        return R.ok(orderReturnApplyList);
    }

    @ApiOperation("批量删除申请")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        int count = omsOrderReturnApplyService.delete(ids);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取退货申请详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        OmsOrderReturnApplyResult result = omsOrderReturnApplyService.getItem(id);
        return R.ok(result);
    }

    @ApiOperation("修改申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam) {
        int count = omsOrderReturnApplyService.updateStatus(id, statusParam);
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
        PageUtils page = omsOrderReturnApplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        OmsOrderReturnApplyEntity omsOrderReturnApply = omsOrderReturnApplyService.getById(id);

        return R.ok().put("omsOrderReturnApply", omsOrderReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OmsOrderReturnApplyEntity omsOrderReturnApply) {
        omsOrderReturnApplyService.save(omsOrderReturnApply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OmsOrderReturnApplyEntity omsOrderReturnApply) {
        omsOrderReturnApplyService.updateById(omsOrderReturnApply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        omsOrderReturnApplyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
