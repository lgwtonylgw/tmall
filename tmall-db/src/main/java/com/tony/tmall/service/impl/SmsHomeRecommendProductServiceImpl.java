package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsHomeRecommendProductDao;
import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.tony.tmall.service.SmsHomeRecommendProductService;


@Service("smsHomeRecommendProductService")
public class SmsHomeRecommendProductServiceImpl extends ServiceImpl<SmsHomeRecommendProductDao, SmsHomeRecommendProductEntity> implements SmsHomeRecommendProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeRecommendProductEntity> page = this.page(
                new Query<SmsHomeRecommendProductEntity>().getPage(params),
                new QueryWrapper<SmsHomeRecommendProductEntity>()
        );

        return new PageUtils(page);
    }

}