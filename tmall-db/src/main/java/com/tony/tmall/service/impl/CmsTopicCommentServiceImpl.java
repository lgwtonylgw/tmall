package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.CmsTopicCommentDao;
import com.tony.tmall.entity.CmsTopicCommentEntity;
import com.tony.tmall.service.CmsTopicCommentService;


@Service("cmsTopicCommentService")
public class CmsTopicCommentServiceImpl extends ServiceImpl<CmsTopicCommentDao, CmsTopicCommentEntity> implements CmsTopicCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsTopicCommentEntity> page = this.page(
                new Query<CmsTopicCommentEntity>().getPage(params),
                new QueryWrapper<CmsTopicCommentEntity>()
        );

        return new PageUtils(page);
    }

}