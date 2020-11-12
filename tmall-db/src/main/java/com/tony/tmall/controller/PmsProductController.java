package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.service.PmsProductService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 商品信息
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/pmsproduct")
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproduct:info")
    public R info(@PathVariable("id") Long id){
		PmsProductEntity pmsProduct = pmsProductService.getById(id);

        return R.ok().put("pmsProduct", pmsProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproduct:save")
    public R save(@RequestBody PmsProductEntity pmsProduct){
		pmsProductService.save(pmsProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproduct:update")
    public R update(@RequestBody PmsProductEntity pmsProduct){
		pmsProductService.updateById(pmsProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproduct:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
