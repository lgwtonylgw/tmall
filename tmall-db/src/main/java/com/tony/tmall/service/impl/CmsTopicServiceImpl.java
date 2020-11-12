package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.CmsTopicDao;
import com.tony.tmall.entity.CmsTopicEntity;
import com.tony.tmall.service.CmsTopicService;


@Service("cmsTopicService")
public class CmsTopicServiceImpl extends ServiceImpl<CmsTopicDao, CmsTopicEntity> implements CmsTopicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsTopicEntity> page = this.page(
                new Query<CmsTopicEntity>().getPage(params),
                new QueryWrapper<CmsTopicEntity>()
        );

        return new PageUtils(page);
    }

}