package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsSubjectCommentDao;
import com.tony.tmall.entity.CmsSubjectCommentEntity;
import com.tony.tmall.service.CmsSubjectCommentService;


@Service("cmsSubjectCommentService")
public class CmsSubjectCommentServiceImpl extends ServiceImpl<CmsSubjectCommentDao, CmsSubjectCommentEntity> implements CmsSubjectCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsSubjectCommentEntity> page = this.page(
                new Query<CmsSubjectCommentEntity>().getPage(params),
                new QueryWrapper<CmsSubjectCommentEntity>()
        );

        return new PageUtils(page);
    }

}