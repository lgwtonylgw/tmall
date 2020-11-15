package com.tony.tmall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.common.model.enums.ResultCode;
import com.tony.tmall.entity.PmsSkuStockEntity;
import com.tony.tmall.service.PmsSkuStockService;
import com.tony.tmall.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * sku的库存
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@Api(tags = "PmsSkuStockController", description = "sku商品库存管理")
@RequestMapping("/sku")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService pmsSkuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public R getList(@PathVariable Long pid, @RequestParam(value = "keyword", required = false) String keyword) {
        LambdaQueryWrapper<PmsSkuStockEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PmsSkuStockEntity::getProductId, pid);
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(PmsSkuStockEntity::getSkuCode, keyword);
        }
        List<PmsSkuStockEntity> skuStockList = pmsSkuStockService.list(wrapper);
        return R.ok(skuStockList);
    }

    @ApiOperation("批量更新库存信息")
    @RequestMapping(value = "/update/{pid}", method = RequestMethod.POST)
    @ResponseBody
    public R update(@PathVariable Long pid, @RequestBody List<PmsSkuStockEntity> skuStockList) {
        int count = pmsSkuStockService.updateByPid(pid, skuStockList);
        if (count > 0) {
            return R.ok(count);
        } else {
            return R.error(ResultCode.FAILED);
        }
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsskustock:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsSkuStockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsskustock:info")
    public R info(@PathVariable("id") Long id) {
        PmsSkuStockEntity pmsSkuStock = pmsSkuStockService.getById(id);

        return R.ok().put("pmsSkuStock", pmsSkuStock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsskustock:save")
    public R save(@RequestBody PmsSkuStockEntity pmsSkuStock) {
        pmsSkuStockService.save(pmsSkuStock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsskustock:update")
    public R update(@RequestBody PmsSkuStockEntity pmsSkuStock) {
        pmsSkuStockService.updateById(pmsSkuStock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsskustock:delete")
    public R delete(@RequestBody Long[] ids) {
        pmsSkuStockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
