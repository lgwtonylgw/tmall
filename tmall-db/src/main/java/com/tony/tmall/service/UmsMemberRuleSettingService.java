package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsMemberRuleSettingEntity;

import java.util.Map;

/**
 * 会员积分成长规则表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsMemberRuleSettingService extends IService<UmsMemberRuleSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

