package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsSkuStockDao;
import com.tony.tmall.entity.PmsSkuStockEntity;
import com.tony.tmall.service.PmsSkuStockService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("pmsSkuStockService")
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockDao, PmsSkuStockEntity> implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockDao pmsSkuStockDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSkuStockEntity> page = this.page(
                new Query<PmsSkuStockEntity>().getPage(params),
                new QueryWrapper<PmsSkuStockEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int updateByPid(Long pid, List<PmsSkuStockEntity> skuStockList) {
        return pmsSkuStockDao.replaceList(skuStockList);
    }

}