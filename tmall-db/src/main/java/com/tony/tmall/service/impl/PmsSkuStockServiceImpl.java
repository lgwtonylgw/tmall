package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsSkuStockDao;
import com.tony.tmall.entity.PmsSkuStockEntity;
import com.tony.tmall.service.PmsSkuStockService;


@Service("pmsSkuStockService")
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockDao, PmsSkuStockEntity> implements PmsSkuStockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSkuStockEntity> page = this.page(
                new Query<PmsSkuStockEntity>().getPage(params),
                new QueryWrapper<PmsSkuStockEntity>()
        );

        return new PageUtils(page);
    }

}