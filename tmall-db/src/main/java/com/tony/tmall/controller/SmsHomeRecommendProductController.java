package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.tony.tmall.service.SmsHomeRecommendProductService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 人气推荐商品表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smshomerecommendproduct")
public class SmsHomeRecommendProductController {
    @Autowired
    private SmsHomeRecommendProductService smsHomeRecommendProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomerecommendproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeRecommendProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomerecommendproduct:info")
    public R info(@PathVariable("id") Long id){
		SmsHomeRecommendProductEntity smsHomeRecommendProduct = smsHomeRecommendProductService.getById(id);

        return R.ok().put("smsHomeRecommendProduct", smsHomeRecommendProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomerecommendproduct:save")
    public R save(@RequestBody SmsHomeRecommendProductEntity smsHomeRecommendProduct){
		smsHomeRecommendProductService.save(smsHomeRecommendProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomerecommendproduct:update")
    public R update(@RequestBody SmsHomeRecommendProductEntity smsHomeRecommendProduct){
		smsHomeRecommendProductService.updateById(smsHomeRecommendProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomerecommendproduct:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeRecommendProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
