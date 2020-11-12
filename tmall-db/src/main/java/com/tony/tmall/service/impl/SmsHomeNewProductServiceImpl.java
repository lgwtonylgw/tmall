package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsHomeNewProductDao;
import com.tony.tmall.entity.SmsHomeNewProductEntity;
import com.tony.tmall.service.SmsHomeNewProductService;


@Service("smsHomeNewProductService")
public class SmsHomeNewProductServiceImpl extends ServiceImpl<SmsHomeNewProductDao, SmsHomeNewProductEntity> implements SmsHomeNewProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeNewProductEntity> page = this.page(
                new Query<SmsHomeNewProductEntity>().getPage(params),
                new QueryWrapper<SmsHomeNewProductEntity>()
        );

        return new PageUtils(page);
    }

}