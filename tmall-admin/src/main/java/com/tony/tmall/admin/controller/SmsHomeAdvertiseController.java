package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.SmsHomeAdvertiseEntity;
import com.tony.tmall.service.SmsHomeAdvertiseService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 首页轮播广告
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "SmsHomeAdvertiseController", description = "首页轮播广告管理")
@RequestMapping("/home/advertise")
public class SmsHomeAdvertiseController {
    @Autowired
    private SmsHomeAdvertiseService smsHomeAdvertiseService;


    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public R create(@RequestBody SmsHomeAdvertiseEntity advertise) {
        advertise.setClickCount(0);
        advertise.setOrderCount(0);
        boolean success = smsHomeAdvertiseService.save(advertise);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestParam("ids") List<Long> ids) {
        boolean success = smsHomeAdvertiseService.removeByIds(ids);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R updateStatus(@PathVariable Long id, Integer status) {
        SmsHomeAdvertiseEntity record = new SmsHomeAdvertiseEntity();
        record.setId(id);
        record.setStatus(status);
        boolean success = smsHomeAdvertiseService.updateById(record);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("获取广告详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R getItem(@PathVariable Long id) {
        SmsHomeAdvertiseEntity advertise = smsHomeAdvertiseService.getById(id);
        return R.ok(advertise);
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long id, @RequestBody SmsHomeAdvertiseEntity advertise) {
        advertise.setId(id);
        boolean success = smsHomeAdvertiseService.updateById(advertise);
        if (success) {
            return R.ok(success);
        }
        return R.error(ResultCode.FAILED);
    }

    @ApiOperation("分页查询广告")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list(@RequestParam(value = "name", required = false) String name,
                  @RequestParam(value = "type", required = false) Integer type,
                  @RequestParam(value = "endTime", required = false) String endTime,
                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SmsHomeAdvertiseEntity> advertiseList = smsHomeAdvertiseService.listByPage(name, type, endTime, pageSize, pageNum);
        return R.ok(advertiseList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomeadvertise:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = smsHomeAdvertiseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomeadvertise:info")
    public R info(@PathVariable("id") Long id) {
        SmsHomeAdvertiseEntity smsHomeAdvertise = smsHomeAdvertiseService.getById(id);

        return R.ok().put("smsHomeAdvertise", smsHomeAdvertise);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomeadvertise:save")
    public R save(@RequestBody SmsHomeAdvertiseEntity smsHomeAdvertise) {
        smsHomeAdvertiseService.save(smsHomeAdvertise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomeadvertise:update")
    public R update(@RequestBody SmsHomeAdvertiseEntity smsHomeAdvertise) {
        smsHomeAdvertiseService.updateById(smsHomeAdvertise);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomeadvertise:delete")
    public R delete(@RequestBody Long[] ids) {
        smsHomeAdvertiseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
