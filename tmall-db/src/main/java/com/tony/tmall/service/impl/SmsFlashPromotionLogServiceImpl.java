package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.SmsFlashPromotionLogDao;
import com.tony.tmall.entity.SmsFlashPromotionLogEntity;
import com.tony.tmall.service.SmsFlashPromotionLogService;


@Service("smsFlashPromotionLogService")
public class SmsFlashPromotionLogServiceImpl extends ServiceImpl<SmsFlashPromotionLogDao, SmsFlashPromotionLogEntity> implements SmsFlashPromotionLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsFlashPromotionLogEntity> page = this.page(
                new Query<SmsFlashPromotionLogEntity>().getPage(params),
                new QueryWrapper<SmsFlashPromotionLogEntity>()
        );

        return new PageUtils(page);
    }

}