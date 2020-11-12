package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsFlashPromotionDao;
import com.tony.tmall.entity.SmsFlashPromotionEntity;
import com.tony.tmall.service.SmsFlashPromotionService;


@Service("smsFlashPromotionService")
public class SmsFlashPromotionServiceImpl extends ServiceImpl<SmsFlashPromotionDao, SmsFlashPromotionEntity> implements SmsFlashPromotionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsFlashPromotionEntity> page = this.page(
                new Query<SmsFlashPromotionEntity>().getPage(params),
                new QueryWrapper<SmsFlashPromotionEntity>()
        );

        return new PageUtils(page);
    }

}