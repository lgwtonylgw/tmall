package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsMemberPriceDao;
import com.tony.tmall.entity.PmsMemberPriceEntity;
import com.tony.tmall.service.PmsMemberPriceService;


@Service("pmsMemberPriceService")
public class PmsMemberPriceServiceImpl extends ServiceImpl<PmsMemberPriceDao, PmsMemberPriceEntity> implements PmsMemberPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsMemberPriceEntity> page = this.page(
                new Query<PmsMemberPriceEntity>().getPage(params),
                new QueryWrapper<PmsMemberPriceEntity>()
        );

        return new PageUtils(page);
    }

}