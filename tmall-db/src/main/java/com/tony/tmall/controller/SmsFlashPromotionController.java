package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsFlashPromotionEntity;
import com.tony.tmall.service.SmsFlashPromotionService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 限时购表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smsflashpromotion")
public class SmsFlashPromotionController {
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsFlashPromotionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotion:info")
    public R info(@PathVariable("id") Long id){
		SmsFlashPromotionEntity smsFlashPromotion = smsFlashPromotionService.getById(id);

        return R.ok().put("smsFlashPromotion", smsFlashPromotion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotion:save")
    public R save(@RequestBody SmsFlashPromotionEntity smsFlashPromotion){
		smsFlashPromotionService.save(smsFlashPromotion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotion:update")
    public R update(@RequestBody SmsFlashPromotionEntity smsFlashPromotion){
		smsFlashPromotionService.updateById(smsFlashPromotion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotion:delete")
    public R delete(@RequestBody Long[] ids){
		smsFlashPromotionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
