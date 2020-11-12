package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.UmsMemberMemberTagRelationDao;
import com.tony.tmall.entity.UmsMemberMemberTagRelationEntity;
import com.tony.tmall.service.UmsMemberMemberTagRelationService;


@Service("umsMemberMemberTagRelationService")
public class UmsMemberMemberTagRelationServiceImpl extends ServiceImpl<UmsMemberMemberTagRelationDao, UmsMemberMemberTagRelationEntity> implements UmsMemberMemberTagRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberMemberTagRelationEntity> page = this.page(
                new Query<UmsMemberMemberTagRelationEntity>().getPage(params),
                new QueryWrapper<UmsMemberMemberTagRelationEntity>()
        );

        return new PageUtils(page);
    }

}