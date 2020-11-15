package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.OmsOrderSettingDao;
import com.tony.tmall.entity.OmsOrderSettingEntity;
import com.tony.tmall.service.OmsOrderSettingService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingDao, OmsOrderSettingEntity> implements OmsOrderSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderSettingEntity> page = this.page(
                new Query<OmsOrderSettingEntity>().getPage(params),
                new QueryWrapper<OmsOrderSettingEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public OmsOrderSettingEntity getItem(Long id) {
        return getById(id);
    }
}