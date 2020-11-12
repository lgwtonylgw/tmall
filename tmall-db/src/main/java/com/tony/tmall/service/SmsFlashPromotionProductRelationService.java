package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;

import java.util.Map;

/**
 * 商品限时购与商品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsFlashPromotionProductRelationService extends IService<SmsFlashPromotionProductRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

