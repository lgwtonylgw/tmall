package com.tony.tmall.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品限时购与商品关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface SmsFlashPromotionProductRelationDao extends BaseMapper<SmsFlashPromotionProductRelationEntity> {

    Page<SmsFlashPromotionProduct> getList(Page<SmsFlashPromotionProductRelationEntity> page,
                                           @Param("flashPromotionId") Long flashPromotionId,
                                           @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
