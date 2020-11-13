package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsMemberTaskDao;
import com.tony.tmall.entity.UmsMemberTaskEntity;
import com.tony.tmall.service.UmsMemberTaskService;


@Service("umsMemberTaskService")
public class UmsMemberTaskServiceImpl extends ServiceImpl<UmsMemberTaskDao, UmsMemberTaskEntity> implements UmsMemberTaskService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberTaskEntity> page = this.page(
                new Query<UmsMemberTaskEntity>().getPage(params),
                new QueryWrapper<UmsMemberTaskEntity>()
        );

        return new PageUtils(page);
    }

}