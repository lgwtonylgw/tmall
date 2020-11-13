package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.SmsCouponProductCategoryRelationDao;
import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;
import com.tony.tmall.service.SmsCouponProductCategoryRelationService;


@Service("smsCouponProductCategoryRelationService")
public class SmsCouponProductCategoryRelationServiceImpl extends ServiceImpl<SmsCouponProductCategoryRelationDao, SmsCouponProductCategoryRelationEntity> implements SmsCouponProductCategoryRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponProductCategoryRelationEntity> page = this.page(
                new Query<SmsCouponProductCategoryRelationEntity>().getPage(params),
                new QueryWrapper<SmsCouponProductCategoryRelationEntity>()
        );

        return new PageUtils(page);
    }

}