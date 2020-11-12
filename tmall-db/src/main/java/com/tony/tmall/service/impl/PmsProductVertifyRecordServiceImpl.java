package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductVertifyRecordDao;
import com.tony.tmall.entity.PmsProductVertifyRecordEntity;
import com.tony.tmall.service.PmsProductVertifyRecordService;


@Service("pmsProductVertifyRecordService")
public class PmsProductVertifyRecordServiceImpl extends ServiceImpl<PmsProductVertifyRecordDao, PmsProductVertifyRecordEntity> implements PmsProductVertifyRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductVertifyRecordEntity> page = this.page(
                new Query<PmsProductVertifyRecordEntity>().getPage(params),
                new QueryWrapper<PmsProductVertifyRecordEntity>()
        );

        return new PageUtils(page);
    }

}