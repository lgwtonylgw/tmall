package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsHelpCategoryDao;
import com.tony.tmall.entity.CmsHelpCategoryEntity;
import com.tony.tmall.service.CmsHelpCategoryService;


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