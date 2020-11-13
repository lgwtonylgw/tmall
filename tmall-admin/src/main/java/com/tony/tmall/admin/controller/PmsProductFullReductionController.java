package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsProductFullReductionEntity;
import com.tony.tmall.service.PmsProductFullReductionService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 产品满减表(只针对同商品)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductfullreduction")
public class PmsProductFullReductionController {
    @Autowired
    private PmsProductFullReductionService pmsProductFullReductionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductfullreduction:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductFullReductionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductfullreduction:info")
    public R info(@PathVariable("id") Long id){
		PmsProductFullReductionEntity pmsProductFullReduction = pmsProductFullReductionService.getById(id);

        return R.ok().put("pmsProductFullReduction", pmsProductFullReduction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductfullreduction:save")
    public R save(@RequestBody PmsProductFullReductionEntity pmsProductFullReduction){
		pmsProductFullReductionService.save(pmsProductFullReduction);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductfullreduction:update")
    public R update(@RequestBody PmsProductFullReductionEntity pmsProductFullReduction){
		pmsProductFullReductionService.updateById(pmsProductFullReduction);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductfullreduction:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductFullReductionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
