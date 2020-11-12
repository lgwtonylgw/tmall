package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.PmsProductOperateLogEntity;
import com.tony.tmall.service.PmsProductOperateLogService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/pmsproductoperatelog")
public class PmsProductOperateLogController {
    @Autowired
    private PmsProductOperateLogService pmsProductOperateLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:pmsproductoperatelog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductOperateLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:pmsproductoperatelog:info")
    public R info(@PathVariable("id") Long id){
		PmsProductOperateLogEntity pmsProductOperateLog = pmsProductOperateLogService.getById(id);

        return R.ok().put("pmsProductOperateLog", pmsProductOperateLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:pmsproductoperatelog:save")
    public R save(@RequestBody PmsProductOperateLogEntity pmsProductOperateLog){
		pmsProductOperateLogService.save(pmsProductOperateLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:pmsproductoperatelog:update")
    public R update(@RequestBody PmsProductOperateLogEntity pmsProductOperateLog){
		pmsProductOperateLogService.updateById(pmsProductOperateLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:pmsproductoperatelog:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductOperateLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
