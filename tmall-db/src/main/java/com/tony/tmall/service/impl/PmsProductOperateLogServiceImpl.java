package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.PmsProductOperateLogDao;
import com.tony.tmall.entity.PmsProductOperateLogEntity;
import com.tony.tmall.service.PmsProductOperateLogService;


@Service("pmsProductOperateLogService")
public class PmsProductOperateLogServiceImpl extends ServiceImpl<PmsProductOperateLogDao, PmsProductOperateLogEntity> implements PmsProductOperateLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductOperateLogEntity> page = this.page(
                new Query<PmsProductOperateLogEntity>().getPage(params),
                new QueryWrapper<PmsProductOperateLogEntity>()
        );

        return new PageUtils(page);
    }

}