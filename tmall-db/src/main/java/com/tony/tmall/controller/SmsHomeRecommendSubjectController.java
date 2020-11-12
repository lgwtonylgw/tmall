package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsHomeRecommendSubjectEntity;
import com.tony.tmall.service.SmsHomeRecommendSubjectService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 首页推荐专题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smshomerecommendsubject")
public class SmsHomeRecommendSubjectController {
    @Autowired
    private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smshomerecommendsubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsHomeRecommendSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smshomerecommendsubject:info")
    public R info(@PathVariable("id") Long id){
		SmsHomeRecommendSubjectEntity smsHomeRecommendSubject = smsHomeRecommendSubjectService.getById(id);

        return R.ok().put("smsHomeRecommendSubject", smsHomeRecommendSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smshomerecommendsubject:save")
    public R save(@RequestBody SmsHomeRecommendSubjectEntity smsHomeRecommendSubject){
		smsHomeRecommendSubjectService.save(smsHomeRecommendSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smshomerecommendsubject:update")
    public R update(@RequestBody SmsHomeRecommendSubjectEntity smsHomeRecommendSubject){
		smsHomeRecommendSubjectService.updateById(smsHomeRecommendSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smshomerecommendsubject:delete")
    public R delete(@RequestBody Long[] ids){
		smsHomeRecommendSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
