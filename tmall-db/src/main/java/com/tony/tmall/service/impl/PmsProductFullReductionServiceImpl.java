package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductFullReductionDao;
import com.tony.tmall.entity.PmsProductFullReductionEntity;
import com.tony.tmall.service.PmsProductFullReductionService;


@Service("pmsProductFullReductionService")
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionDao, PmsProductFullReductionEntity> implements PmsProductFullReductionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductFullReductionEntity> page = this.page(
                new Query<PmsProductFullReductionEntity>().getPage(params),
                new QueryWrapper<PmsProductFullReductionEntity>()
        );

        return new PageUtils(page);
    }

}