package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsBrandEntity;
import com.tony.tmall.service.PmsBrandService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 品牌表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/pmsbrand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsbrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsbrand:info")
    public R info(@PathVariable("id") Long id){
		PmsBrandEntity pmsBrand = pmsBrandService.getById(id);

        return R.ok().put("pmsBrand", pmsBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsbrand:save")
    public R save(@RequestBody PmsBrandEntity pmsBrand){
		pmsBrandService.save(pmsBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsbrand:update")
    public R update(@RequestBody PmsBrandEntity pmsBrand){
		pmsBrandService.updateById(pmsBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsbrand:delete")
    public R delete(@RequestBody Long[] ids){
		pmsBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
