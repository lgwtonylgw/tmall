package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsMenuDao;
import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.service.UmsMenuService;


@Service("umsMenuService")
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuDao, UmsMenuEntity> implements UmsMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMenuEntity> page = this.page(
                new Query<UmsMenuEntity>().getPage(params),
                new QueryWrapper<UmsMenuEntity>()
        );

        return new PageUtils(page);
    }

}