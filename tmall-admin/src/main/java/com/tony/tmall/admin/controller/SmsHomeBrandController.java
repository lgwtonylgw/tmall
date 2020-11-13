package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.SmsHomeBrandEntity;
import com.tony.tmall.service.SmsHomeBrandService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 首页推荐品牌表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smshomebrand")
public class SmsHomeBrandController {
    @Autowired
    private SmsHomeBrandService smsHomeBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomebrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomebrand:info")
    public R info(@PathVariable("id") Long id){
		SmsHomeBrandEntity smsHomeBrand = smsHomeBrandService.getById(id);

        return R.ok().put("smsHomeBrand", smsHomeBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomebrand:save")
    public R save(@RequestBody SmsHomeBrandEntity smsHomeBrand){
		smsHomeBrandService.save(smsHomeBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomebrand:update")
    public R update(@RequestBody SmsHomeBrandEntity smsHomeBrand){
		smsHomeBrandService.updateById(smsHomeBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomebrand:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
