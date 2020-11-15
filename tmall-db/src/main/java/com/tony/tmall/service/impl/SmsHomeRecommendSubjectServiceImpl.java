package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsHomeRecommendSubjectDao;
import com.tony.tmall.entity.SmsHomeRecommendSubjectEntity;
import com.tony.tmall.service.SmsHomeRecommendSubjectService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


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

    @Override
    @Transactional
    public int create(List<SmsHomeRecommendSubjectEntity> homeBrandList) {
        for (SmsHomeRecommendSubjectEntity recommendProduct : homeBrandList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            baseMapper.insert(recommendProduct);
        }
        return homeBrandList.size();
    }

}