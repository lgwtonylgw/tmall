package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.CmsSubjectDao;
import com.tony.tmall.entity.CmsSubjectEntity;
import com.tony.tmall.service.CmsSubjectService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cmsSubjectService")
public class CmsSubjectServiceImpl extends ServiceImpl<CmsSubjectDao, CmsSubjectEntity> implements CmsSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsSubjectEntity> page = this.page(
                new Query<CmsSubjectEntity>().getPage(params),
                new QueryWrapper<CmsSubjectEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listByName(String keyword, Integer pageNum, Integer pageSize) {
        IPage<CmsSubjectEntity> page = this.page(
                new Page<>(pageNum, pageNum),
                new QueryWrapper<CmsSubjectEntity>().like("title", keyword)
        );

        return new PageUtils(page);
    }
}