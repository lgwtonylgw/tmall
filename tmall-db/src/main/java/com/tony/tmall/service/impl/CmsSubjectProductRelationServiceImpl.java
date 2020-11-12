package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsSubjectProductRelationDao;
import com.tony.tmall.entity.CmsSubjectProductRelationEntity;
import com.tony.tmall.service.CmsSubjectProductRelationService;


@Service("cmsSubjectProductRelationService")
public class CmsSubjectProductRelationServiceImpl extends ServiceImpl<CmsSubjectProductRelationDao, CmsSubjectProductRelationEntity> implements CmsSubjectProductRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsSubjectProductRelationEntity> page = this.page(
                new Query<CmsSubjectProductRelationEntity>().getPage(params),
                new QueryWrapper<CmsSubjectProductRelationEntity>()
        );

        return new PageUtils(page);
    }

}