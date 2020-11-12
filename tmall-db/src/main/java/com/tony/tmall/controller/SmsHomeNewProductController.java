package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsHomeNewProductEntity;
import com.tony.tmall.service.SmsHomeNewProductService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 新鲜好物表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smshomenewproduct")
public class SmsHomeNewProductController {
    @Autowired
    private SmsHomeNewProductService smsHomeNewProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomenewproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeNewProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomenewproduct:info")
    public R info(@PathVariable("id") Long id){
		SmsHomeNewProductEntity smsHomeNewProduct = smsHomeNewProductService.getById(id);

        return R.ok().put("smsHomeNewProduct", smsHomeNewProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomenewproduct:save")
    public R save(@RequestBody SmsHomeNewProductEntity smsHomeNewProduct){
		smsHomeNewProductService.save(smsHomeNewProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomenewproduct:update")
    public R update(@RequestBody SmsHomeNewProductEntity smsHomeNewProduct){
		smsHomeNewProductService.updateById(smsHomeNewProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomenewproduct:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeNewProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
