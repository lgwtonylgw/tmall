package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsFlashPromotionSessionDao;
import com.tony.tmall.entity.SmsFlashPromotionSessionEntity;
import com.tony.tmall.service.SmsFlashPromotionSessionService;


@Service("smsFlashPromotionSessionService")
public class SmsFlashPromotionSessionServiceImpl extends ServiceImpl<SmsFlashPromotionSessionDao, SmsFlashPromotionSessionEntity> implements SmsFlashPromotionSessionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsFlashPromotionSessionEntity> page = this.page(
                new Query<SmsFlashPromotionSessionEntity>().getPage(params),
                new QueryWrapper<SmsFlashPromotionSessionEntity>()
        );

        return new PageUtils(page);
    }

}