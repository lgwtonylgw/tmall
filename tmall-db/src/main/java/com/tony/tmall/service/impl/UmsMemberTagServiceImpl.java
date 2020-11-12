package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.UmsMemberTagDao;
import com.tony.tmall.entity.UmsMemberTagEntity;
import com.tony.tmall.service.UmsMemberTagService;


@Service("umsMemberTagService")
public class UmsMemberTagServiceImpl extends ServiceImpl<UmsMemberTagDao, UmsMemberTagEntity> implements UmsMemberTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberTagEntity> page = this.page(
                new Query<UmsMemberTagEntity>().getPage(params),
                new QueryWrapper<UmsMemberTagEntity>()
        );

        return new PageUtils(page);
    }

}