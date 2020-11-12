package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.UmsMemberProductCategoryRelationDao;
import com.tony.tmall.entity.UmsMemberProductCategoryRelationEntity;
import com.tony.tmall.service.UmsMemberProductCategoryRelationService;


@Service("umsMemberProductCategoryRelationService")
public class UmsMemberProductCategoryRelationServiceImpl extends ServiceImpl<UmsMemberProductCategoryRelationDao, UmsMemberProductCategoryRelationEntity> implements UmsMemberProductCategoryRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberProductCategoryRelationEntity> page = this.page(
                new Query<UmsMemberProductCategoryRelationEntity>().getPage(params),
                new QueryWrapper<UmsMemberProductCategoryRelationEntity>()
        );

        return new PageUtils(page);
    }

}