package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsPrefrenceAreaProductRelationDao;
import com.tony.tmall.entity.CmsPrefrenceAreaProductRelationEntity;
import com.tony.tmall.service.CmsPrefrenceAreaProductRelationService;


@Service("cmsPrefrenceAreaProductRelationService")
public class CmsPrefrenceAreaProductRelationServiceImpl extends ServiceImpl<CmsPrefrenceAreaProductRelationDao, CmsPrefrenceAreaProductRelationEntity> implements CmsPrefrenceAreaProductRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsPrefrenceAreaProductRelationEntity> page = this.page(
                new Query<CmsPrefrenceAreaProductRelationEntity>().getPage(params),
                new QueryWrapper<CmsPrefrenceAreaProductRelationEntity>()
        );

        return new PageUtils(page);
    }

}