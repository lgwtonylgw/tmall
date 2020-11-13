package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.SmsFlashPromotionProductRelationDao;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import com.tony.tmall.service.SmsFlashPromotionProductRelationService;


@Service("smsFlashPromotionProductRelationService")
public class SmsFlashPromotionProductRelationServiceImpl extends ServiceImpl<SmsFlashPromotionProductRelationDao, SmsFlashPromotionProductRelationEntity> implements SmsFlashPromotionProductRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsFlashPromotionProductRelationEntity> page = this.page(
                new Query<SmsFlashPromotionProductRelationEntity>().getPage(params),
                new QueryWrapper<SmsFlashPromotionProductRelationEntity>()
        );

        return new PageUtils(page);
    }

}