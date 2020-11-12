package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.CmsMemberReportEntity;
import com.tony.tmall.service.CmsMemberReportService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 用户举报表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@RestController
@RequestMapping("tmall/cmsmemberreport")
public class CmsMemberReportController {
    @Autowired
    private CmsMemberReportService cmsMemberReportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:cmsmemberreport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsMemberReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:cmsmemberreport:info")
    public R info(@PathVariable("id") Long id){
		CmsMemberReportEntity cmsMemberReport = cmsMemberReportService.getById(id);

        return R.ok().put("cmsMemberReport", cmsMemberReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:cmsmemberreport:save")
    public R save(@RequestBody CmsMemberReportEntity cmsMemberReport){
		cmsMemberReportService.save(cmsMemberReport);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:cmsmemberreport:update")
    public R update(@RequestBody CmsMemberReportEntity cmsMemberReport){
		cmsMemberReportService.updateById(cmsMemberReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:cmsmemberreport:delete")
    public R delete(@RequestBody Long[] ids){
		cmsMemberReportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
