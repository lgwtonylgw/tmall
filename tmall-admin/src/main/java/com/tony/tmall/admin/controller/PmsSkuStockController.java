package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsSkuStockEntity;
import com.tony.tmall.service.PmsSkuStockService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * sku的库存
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsskustock")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService pmsSkuStockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsskustock:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSkuStockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsskustock:info")
    public R info(@PathVariable("id") Long id){
		PmsSkuStockEntity pmsSkuStock = pmsSkuStockService.getById(id);

        return R.ok().put("pmsSkuStock", pmsSkuStock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsskustock:save")
    public R save(@RequestBody PmsSkuStockEntity pmsSkuStock){
		pmsSkuStockService.save(pmsSkuStock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsskustock:update")
    public R update(@RequestBody PmsSkuStockEntity pmsSkuStock){
		pmsSkuStockService.updateById(pmsSkuStock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsskustock:delete")
    public R delete(@RequestBody Long[] ids){
		pmsSkuStockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
