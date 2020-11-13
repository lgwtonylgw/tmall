package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsFlashPromotionSessionEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 限时购场次表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsFlashPromotionSessionService extends IService<SmsFlashPromotionSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

