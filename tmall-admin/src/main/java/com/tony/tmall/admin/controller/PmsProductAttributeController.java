package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.tony.tmall.service.PmsProductAttributeService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 商品属性参数表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/pmsproductattribute")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductattribute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductAttributeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductattribute:info")
    public R info(@PathVariable("id") Long id){
		PmsProductAttributeEntity pmsProductAttribute = pmsProductAttributeService.getById(id);

        return R.ok().put("pmsProductAttribute", pmsProductAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductattribute:save")
    public R save(@RequestBody PmsProductAttributeEntity pmsProductAttribute){
		pmsProductAttributeService.save(pmsProductAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductattribute:update")
    public R update(@RequestBody PmsProductAttributeEntity pmsProductAttribute){
		pmsProductAttributeService.updateById(pmsProductAttribute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductattribute:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductAttributeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
