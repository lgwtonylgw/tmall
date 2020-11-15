package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsHomeNewProductDao;
import com.tony.tmall.entity.SmsHomeNewProductEntity;
import com.tony.tmall.service.SmsHomeNewProductService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


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

    @Override
    @Transactional
    public int create(List<SmsHomeNewProductEntity> homeBrandList) {
        for (SmsHomeNewProductEntity SmsHomeNewProduct : homeBrandList) {
            SmsHomeNewProduct.setRecommendStatus(1);
            SmsHomeNewProduct.setSort(0);
            this.baseMapper.insert(SmsHomeNewProduct);
        }
        return homeBrandList.size();
    }

}