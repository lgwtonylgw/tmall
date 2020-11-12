package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsHomeRecommendSubjectDao;
import com.tony.tmall.entity.SmsHomeRecommendSubjectEntity;
import com.tony.tmall.service.SmsHomeRecommendSubjectService;


@Service("smsHomeRecommendSubjectService")
public class SmsHomeRecommendSubjectServiceImpl extends ServiceImpl<SmsHomeRecommendSubjectDao, SmsHomeRecommendSubjectEntity> implements SmsHomeRecommendSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeRecommendSubjectEntity> page = this.page(
                new Query<SmsHomeRecommendSubjectEntity>().getPage(params),
                new QueryWrapper<SmsHomeRecommendSubjectEntity>()
        );

        return new PageUtils(page);
    }

}