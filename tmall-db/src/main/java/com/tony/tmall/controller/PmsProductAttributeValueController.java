package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductAttributeValueEntity;
import com.tony.tmall.service.PmsProductAttributeValueService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 存储产品参数信息的表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductattributevalue")
public class PmsProductAttributeValueController {
    @Autowired
    private PmsProductAttributeValueService pmsProductAttributeValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductattributevalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductAttributeValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductattributevalue:info")
    public R info(@PathVariable("id") Long id){
		PmsProductAttributeValueEntity pmsProductAttributeValue = pmsProductAttributeValueService.getById(id);

        return R.ok().put("pmsProductAttributeValue", pmsProductAttributeValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductattributevalue:save")
    public R save(@RequestBody PmsProductAttributeValueEntity pmsProductAttributeValue){
		pmsProductAttributeValueService.save(pmsProductAttributeValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductattributevalue:update")
    public R update(@RequestBody PmsProductAttributeValueEntity pmsProductAttributeValue){
		pmsProductAttributeValueService.updateById(pmsProductAttributeValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductattributevalue:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductAttributeValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
