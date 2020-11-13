package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import com.tony.tmall.service.SmsCouponProductRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 优惠券和产品的关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smscouponproductrelation")
public class SmsCouponProductRelationController {
    @Autowired
    private SmsCouponProductRelationService smsCouponProductRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smscouponproductrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponProductRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smscouponproductrelation:info")
    public R info(@PathVariable("id") Long id){
		SmsCouponProductRelationEntity smsCouponProductRelation = smsCouponProductRelationService.getById(id);

        return R.ok().put("smsCouponProductRelation", smsCouponProductRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smscouponproductrelation:save")
    public R save(@RequestBody SmsCouponProductRelationEntity smsCouponProductRelation){
		smsCouponProductRelationService.save(smsCouponProductRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smscouponproductrelation:update")
    public R update(@RequestBody SmsCouponProductRelationEntity smsCouponProductRelation){
		smsCouponProductRelationService.updateById(smsCouponProductRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smscouponproductrelation:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponProductRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
