package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.tony.tmall.model.vo.SmsFlashPromotionProduct;
import com.tony.tmall.util.PageUtils;

import java.util.List;
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

    int create(List<SmsFlashPromotionProductRelationEntity> relationList);

    Page<SmsFlashPromotionProduct> getList(Page<SmsFlashPromotionProductRelationEntity> page, Long flashPromotionId, Long flashPromotionSessionId);

    long getCount(Long flashPromotionId, Long id);
}

