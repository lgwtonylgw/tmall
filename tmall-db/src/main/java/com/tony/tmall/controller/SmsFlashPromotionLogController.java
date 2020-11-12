package com.tony.tmall.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tony.tmall.entity.SmsFlashPromotionLogEntity;
import com.tony.tmall.service.SmsFlashPromotionLogService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.R;



/**
 * 限时购通知记录
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smsflashpromotionlog")
public class SmsFlashPromotionLogController {
    @Autowired
    private SmsFlashPromotionLogService smsFlashPromotionLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotionlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsFlashPromotionLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotionlog:info")
    public R info(@PathVariable("id") Integer id){
		SmsFlashPromotionLogEntity smsFlashPromotionLog = smsFlashPromotionLogService.getById(id);

        return R.ok().put("smsFlashPromotionLog", smsFlashPromotionLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotionlog:save")
    public R save(@RequestBody SmsFlashPromotionLogEntity smsFlashPromotionLog){
		smsFlashPromotionLogService.save(smsFlashPromotionLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotionlog:update")
    public R update(@RequestBody SmsFlashPromotionLogEntity smsFlashPromotionLog){
		smsFlashPromotionLogService.updateById(smsFlashPromotionLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotionlog:delete")
    public R delete(@RequestBody Integer[] ids){
		smsFlashPromotionLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
