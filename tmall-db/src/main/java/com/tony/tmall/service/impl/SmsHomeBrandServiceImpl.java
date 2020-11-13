package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.SmsHomeBrandDao;
import com.tony.tmall.entity.SmsHomeBrandEntity;
import com.tony.tmall.service.SmsHomeBrandService;


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

}