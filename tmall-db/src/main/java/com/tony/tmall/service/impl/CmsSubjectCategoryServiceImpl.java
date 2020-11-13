package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.CmsSubjectCategoryDao;
import com.tony.tmall.entity.CmsSubjectCategoryEntity;
import com.tony.tmall.service.CmsSubjectCategoryService;


@Service("cmsSubjectCategoryService")
public class CmsSubjectCategoryServiceImpl extends ServiceImpl<CmsSubjectCategoryDao, CmsSubjectCategoryEntity> implements CmsSubjectCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsSubjectCategoryEntity> page = this.page(
                new Query<CmsSubjectCategoryEntity>().getPage(params),
                new QueryWrapper<CmsSubjectCategoryEntity>()
        );

        return new PageUtils(page);
    }

}