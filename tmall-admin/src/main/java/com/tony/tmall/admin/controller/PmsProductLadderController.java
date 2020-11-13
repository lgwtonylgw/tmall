package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.PmsProductLadderEntity;
import com.tony.tmall.service.PmsProductLadderService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 产品阶梯价格表(只针对同商品)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductladder")
public class PmsProductLadderController {
    @Autowired
    private PmsProductLadderService pmsProductLadderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductladder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductLadderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductladder:info")
    public R info(@PathVariable("id") Long id){
		PmsProductLadderEntity pmsProductLadder = pmsProductLadderService.getById(id);

        return R.ok().put("pmsProductLadder", pmsProductLadder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductladder:save")
    public R save(@RequestBody PmsProductLadderEntity pmsProductLadder){
		pmsProductLadderService.save(pmsProductLadder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductladder:update")
    public R update(@RequestBody PmsProductLadderEntity pmsProductLadder){
		pmsProductLadderService.updateById(pmsProductLadder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductladder:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductLadderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
