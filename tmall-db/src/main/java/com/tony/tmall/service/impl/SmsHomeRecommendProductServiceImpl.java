package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsHomeRecommendProductDao;
import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.tony.tmall.service.SmsHomeRecommendProductService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


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

    @Override
    @Transactional
    public int create(List<SmsHomeRecommendProductEntity> homeBrandList) {
        for (SmsHomeRecommendProductEntity recommendProduct : homeBrandList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            this.baseMapper.insert(recommendProduct);
        }
        return homeBrandList.size();
    }

}