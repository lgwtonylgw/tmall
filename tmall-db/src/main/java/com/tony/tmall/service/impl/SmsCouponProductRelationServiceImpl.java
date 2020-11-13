package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.SmsCouponProductRelationDao;
import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import com.tony.tmall.service.SmsCouponProductRelationService;


@Service("smsCouponProductRelationService")
public class SmsCouponProductRelationServiceImpl extends ServiceImpl<SmsCouponProductRelationDao, SmsCouponProductRelationEntity> implements SmsCouponProductRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponProductRelationEntity> page = this.page(
                new Query<SmsCouponProductRelationEntity>().getPage(params),
                new QueryWrapper<SmsCouponProductRelationEntity>()
        );

        return new PageUtils(page);
    }

}