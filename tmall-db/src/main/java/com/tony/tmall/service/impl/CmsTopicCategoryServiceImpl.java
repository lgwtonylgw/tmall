package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.CmsTopicCategoryDao;
import com.tony.tmall.entity.CmsTopicCategoryEntity;
import com.tony.tmall.service.CmsTopicCategoryService;


@Service("cmsTopicCategoryService")
public class CmsTopicCategoryServiceImpl extends ServiceImpl<CmsTopicCategoryDao, CmsTopicCategoryEntity> implements CmsTopicCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsTopicCategoryEntity> page = this.page(
                new Query<CmsTopicCategoryEntity>().getPage(params),
                new QueryWrapper<CmsTopicCategoryEntity>()
        );

        return new PageUtils(page);
    }

}