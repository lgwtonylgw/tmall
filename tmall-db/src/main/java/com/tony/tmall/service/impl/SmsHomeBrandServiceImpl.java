package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsHomeBrandDao;
import com.tony.tmall.entity.SmsHomeBrandEntity;
import com.tony.tmall.service.SmsHomeBrandService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("smsHomeBrandService")
public class SmsHomeBrandServiceImpl extends ServiceImpl<SmsHomeBrandDao, SmsHomeBrandEntity> implements SmsHomeBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeBrandEntity> page = this.page(
                new Query<SmsHomeBrandEntity>().getPage(params),
                new QueryWrapper<SmsHomeBrandEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public int create(List<SmsHomeBrandEntity> homeBrandList) {
        for (SmsHomeBrandEntity smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
            this.baseMapper.insert(smsHomeBrand);
        }
        return homeBrandList.size();
    }

}