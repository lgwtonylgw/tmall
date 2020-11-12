package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsMemberPriceEntity;
import com.tony.tmall.service.PmsMemberPriceService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 商品会员价格表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsmemberprice")
public class PmsMemberPriceController {
    @Autowired
    private PmsMemberPriceService pmsMemberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsmemberprice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsMemberPriceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsmemberprice:info")
    public R info(@PathVariable("id") Long id){
		PmsMemberPriceEntity pmsMemberPrice = pmsMemberPriceService.getById(id);

        return R.ok().put("pmsMemberPrice", pmsMemberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsmemberprice:save")
    public R save(@RequestBody PmsMemberPriceEntity pmsMemberPrice){
		pmsMemberPriceService.save(pmsMemberPrice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsmemberprice:update")
    public R update(@RequestBody PmsMemberPriceEntity pmsMemberPrice){
		pmsMemberPriceService.updateById(pmsMemberPrice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsmemberprice:delete")
    public R delete(@RequestBody Long[] ids){
		pmsMemberPriceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
