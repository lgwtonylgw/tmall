package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductVertifyRecordEntity;
import com.tony.tmall.service.PmsProductVertifyRecordService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 商品审核记录
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductvertifyrecord")
public class PmsProductVertifyRecordController {
    @Autowired
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductvertifyrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductVertifyRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductvertifyrecord:info")
    public R info(@PathVariable("id") Long id){
		PmsProductVertifyRecordEntity pmsProductVertifyRecord = pmsProductVertifyRecordService.getById(id);

        return R.ok().put("pmsProductVertifyRecord", pmsProductVertifyRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductvertifyrecord:save")
    public R save(@RequestBody PmsProductVertifyRecordEntity pmsProductVertifyRecord){
		pmsProductVertifyRecordService.save(pmsProductVertifyRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductvertifyrecord:update")
    public R update(@RequestBody PmsProductVertifyRecordEntity pmsProductVertifyRecord){
		pmsProductVertifyRecordService.updateById(pmsProductVertifyRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductvertifyrecord:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductVertifyRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
