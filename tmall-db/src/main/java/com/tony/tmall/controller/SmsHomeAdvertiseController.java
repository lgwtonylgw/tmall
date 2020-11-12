package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsHomeAdvertiseEntity;
import com.tony.tmall.service.SmsHomeAdvertiseService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 首页轮播广告表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smshomeadvertise")
public class SmsHomeAdvertiseController {
    @Autowired
    private SmsHomeAdvertiseService smsHomeAdvertiseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomeadvertise:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeAdvertiseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomeadvertise:info")
    public R info(@PathVariable("id") Long id){
		SmsHomeAdvertiseEntity smsHomeAdvertise = smsHomeAdvertiseService.getById(id);

        return R.ok().put("smsHomeAdvertise", smsHomeAdvertise);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomeadvertise:save")
    public R save(@RequestBody SmsHomeAdvertiseEntity smsHomeAdvertise){
		smsHomeAdvertiseService.save(smsHomeAdvertise);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomeadvertise:update")
    public R update(@RequestBody SmsHomeAdvertiseEntity smsHomeAdvertise){
		smsHomeAdvertiseService.updateById(smsHomeAdvertise);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomeadvertise:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeAdvertiseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
