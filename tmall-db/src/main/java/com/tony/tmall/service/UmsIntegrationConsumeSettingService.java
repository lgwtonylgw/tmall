package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsIntegrationConsumeSettingEntity;

import java.util.Map;

/**
 * 积分消费设置
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsIntegrationConsumeSettingService extends IService<UmsIntegrationConsumeSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

