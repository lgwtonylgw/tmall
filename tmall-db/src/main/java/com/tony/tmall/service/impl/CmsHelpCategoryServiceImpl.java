package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.CmsHelpCategoryDao;
import com.tony.tmall.entity.CmsHelpCategoryEntity;
import com.tony.tmall.service.CmsHelpCategoryService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cmsHelpCategoryService")
public class CmsHelpCategoryServiceImpl extends ServiceImpl<CmsHelpCategoryDao, CmsHelpCategoryEntity> implements CmsHelpCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsHelpCategoryEntity> page = this.page(
                new Query<CmsHelpCategoryEntity>().getPage(params),
                new QueryWrapper<CmsHelpCategoryEntity>()
        );

        return new PageUtils(page);
    }

}