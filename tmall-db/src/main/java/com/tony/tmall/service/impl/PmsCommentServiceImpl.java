package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsCommentDao;
import com.tony.tmall.entity.PmsCommentEntity;
import com.tony.tmall.service.PmsCommentService;


@Service("pmsCommentService")
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentDao, PmsCommentEntity> implements PmsCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCommentEntity> page = this.page(
                new Query<PmsCommentEntity>().getPage(params),
                new QueryWrapper<PmsCommentEntity>()
        );

        return new PageUtils(page);
    }

}