package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.SmsFlashPromotionSessionEntity;
import com.tony.tmall.service.SmsFlashPromotionSessionService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 限时购场次表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/smsflashpromotionsession")
public class SmsFlashPromotionSessionController {
    @Autowired
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:smsflashpromotionsession:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsFlashPromotionSessionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:smsflashpromotionsession:info")
    public R info(@PathVariable("id") Long id){
		SmsFlashPromotionSessionEntity smsFlashPromotionSession = smsFlashPromotionSessionService.getById(id);

        return R.ok().put("smsFlashPromotionSession", smsFlashPromotionSession);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:smsflashpromotionsession:save")
    public R save(@RequestBody SmsFlashPromotionSessionEntity smsFlashPromotionSession){
		smsFlashPromotionSessionService.save(smsFlashPromotionSession);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:smsflashpromotionsession:update")
    public R update(@RequestBody SmsFlashPromotionSessionEntity smsFlashPromotionSession){
		smsFlashPromotionSessionService.updateById(smsFlashPromotionSession);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:smsflashpromotionsession:delete")
    public R delete(@RequestBody Long[] ids){
		smsFlashPromotionSessionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
