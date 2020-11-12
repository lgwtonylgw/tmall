package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.OmsCartItemEntity;
import com.tony.tmall.service.OmsCartItemService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 购物车表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/omscartitem")
public class OmsCartItemController {
    @Autowired
    private OmsCartItemService omsCartItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:omscartitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsCartItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:omscartitem:info")
    public R info(@PathVariable("id") Long id){
		OmsCartItemEntity omsCartItem = omsCartItemService.getById(id);

        return R.ok().put("omsCartItem", omsCartItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:omscartitem:save")
    public R save(@RequestBody OmsCartItemEntity omsCartItem){
		omsCartItemService.save(omsCartItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:omscartitem:update")
    public R update(@RequestBody OmsCartItemEntity omsCartItem){
		omsCartItemService.updateById(omsCartItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:omscartitem:delete")
    public R delete(@RequestBody Long[] ids){
		omsCartItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
