package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.tony.tmall.service.SmsFlashPromotionProductRelationService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 商品限时购与商品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smsflashpromotionproductrelation")
public class SmsFlashPromotionProductRelationController {
    @Autowired
    private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsFlashPromotionProductRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:info")
    public R info(@PathVariable("id") Long id){
		SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation = smsFlashPromotionProductRelationService.getById(id);

        return R.ok().put("smsFlashPromotionProductRelation", smsFlashPromotionProductRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:save")
    public R save(@RequestBody SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation){
		smsFlashPromotionProductRelationService.save(smsFlashPromotionProductRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:update")
    public R update(@RequestBody SmsFlashPromotionProductRelationEntity smsFlashPromotionProductRelation){
		smsFlashPromotionProductRelationService.updateById(smsFlashPromotionProductRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotionproductrelation:delete")
    public R delete(@RequestBody Long[] ids){
		smsFlashPromotionProductRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
