package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsResourceCategoryDao;
import com.tony.tmall.entity.UmsResourceCategoryEntity;
import com.tony.tmall.service.UmsResourceCategoryService;


@Service("umsResourceCategoryService")
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryDao, UmsResourceCategoryEntity> implements UmsResourceCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsResourceCategoryEntity> page = this.page(
                new Query<UmsResourceCategoryEntity>().getPage(params),
                new QueryWrapper<UmsResourceCategoryEntity>()
        );

        return new PageUtils(page);
    }

}