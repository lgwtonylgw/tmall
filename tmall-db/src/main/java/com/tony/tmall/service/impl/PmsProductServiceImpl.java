package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductDao;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.service.PmsProductService;


@Service("pmsProductService")
public class PmsProductServiceImpl extends ServiceImpl<PmsProductDao, PmsProductEntity> implements PmsProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductEntity> page = this.page(
                new Query<PmsProductEntity>().getPage(params),
                new QueryWrapper<PmsProductEntity>()
        );

        return new PageUtils(page);
    }

}