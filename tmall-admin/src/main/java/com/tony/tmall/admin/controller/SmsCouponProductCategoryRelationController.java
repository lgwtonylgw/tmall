package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;
import com.tony.tmall.service.SmsCouponProductCategoryRelationService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 优惠券和产品分类关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smscouponproductcategoryrelation")
public class SmsCouponProductCategoryRelationController {
    @Autowired
    private SmsCouponProductCategoryRelationService smsCouponProductCategoryRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smscouponproductcategoryrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponProductCategoryRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smscouponproductcategoryrelation:info")
    public R info(@PathVariable("id") Long id){
		SmsCouponProductCategoryRelationEntity smsCouponProductCategoryRelation = smsCouponProductCategoryRelationService.getById(id);

        return R.ok().put("smsCouponProductCategoryRelation", smsCouponProductCategoryRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smscouponproductcategoryrelation:save")
    public R save(@RequestBody SmsCouponProductCategoryRelationEntity smsCouponProductCategoryRelation){
		smsCouponProductCategoryRelationService.save(smsCouponProductCategoryRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smscouponproductcategoryrelation:update")
    public R update(@RequestBody SmsCouponProductCategoryRelationEntity smsCouponProductCategoryRelation){
		smsCouponProductCategoryRelationService.updateById(smsCouponProductCategoryRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smscouponproductcategoryrelation:delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponProductCategoryRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
