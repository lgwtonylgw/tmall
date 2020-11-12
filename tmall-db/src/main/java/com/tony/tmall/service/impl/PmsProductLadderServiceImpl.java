package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductLadderDao;
import com.tony.tmall.entity.PmsProductLadderEntity;
import com.tony.tmall.service.PmsProductLadderService;


@Service("pmsProductLadderService")
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderDao, PmsProductLadderEntity> implements PmsProductLadderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductLadderEntity> page = this.page(
                new Query<PmsProductLadderEntity>().getPage(params),
                new QueryWrapper<PmsProductLadderEntity>()
        );

        return new PageUtils(page);
    }

}