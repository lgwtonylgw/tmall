package com.tony.tmall.admin.controller;

import com.tony.tmall.common.model.domain.R;
import com.tony.tmall.entity.UmsMemberRuleSettingEntity;
import com.tony.tmall.service.UmsMemberRuleSettingService;
import com.tony.tmall.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员积分成长规则表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@RestController
@RequestMapping("tmall/umsmemberrulesetting")
public class UmsMemberRuleSettingController {
    @Autowired
    private UmsMemberRuleSettingService umsMemberRuleSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tmall:umsmemberrulesetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberRuleSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tmall:umsmemberrulesetting:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberRuleSettingEntity umsMemberRuleSetting = umsMemberRuleSettingService.getById(id);

        return R.ok().put("umsMemberRuleSetting", umsMemberRuleSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tmall:umsmemberrulesetting:save")
    public R save(@RequestBody UmsMemberRuleSettingEntity umsMemberRuleSetting){
		umsMemberRuleSettingService.save(umsMemberRuleSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tmall:umsmemberrulesetting:update")
    public R update(@RequestBody UmsMemberRuleSettingEntity umsMemberRuleSetting){
		umsMemberRuleSettingService.updateById(umsMemberRuleSetting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tmall:umsmemberrulesetting:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberRuleSettingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
