package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsIntegrationConsumeSettingEntity;
import com.tony.tmall.service.UmsIntegrationConsumeSettingService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 积分消费设置
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsintegrationconsumesetting")
public class UmsIntegrationConsumeSettingController {
    @Autowired
    private UmsIntegrationConsumeSettingService umsIntegrationConsumeSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsintegrationconsumesetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsIntegrationConsumeSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsintegrationconsumesetting:info")
    public R info(@PathVariable("id") Long id){
		UmsIntegrationConsumeSettingEntity umsIntegrationConsumeSetting = umsIntegrationConsumeSettingService.getById(id);

        return R.ok().put("umsIntegrationConsumeSetting", umsIntegrationConsumeSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsintegrationconsumesetting:save")
    public R save(@RequestBody UmsIntegrationConsumeSettingEntity umsIntegrationConsumeSetting){
		umsIntegrationConsumeSettingService.save(umsIntegrationConsumeSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsintegrationconsumesetting:update")
    public R update(@RequestBody UmsIntegrationConsumeSettingEntity umsIntegrationConsumeSetting){
		umsIntegrationConsumeSettingService.updateById(umsIntegrationConsumeSetting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsintegrationconsumesetting:delete")
    public R delete(@RequestBody Long[] ids){
		umsIntegrationConsumeSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
