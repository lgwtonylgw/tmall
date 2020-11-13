package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsIntegrationConsumeSettingDao;
import com.tony.tmall.entity.UmsIntegrationConsumeSettingEntity;
import com.tony.tmall.service.UmsIntegrationConsumeSettingService;


@Service("umsIntegrationConsumeSettingService")
public class UmsIntegrationConsumeSettingServiceImpl extends ServiceImpl<UmsIntegrationConsumeSettingDao, UmsIntegrationConsumeSettingEntity> implements UmsIntegrationConsumeSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsIntegrationConsumeSettingEntity> page = this.page(
                new Query<UmsIntegrationConsumeSettingEntity>().getPage(params),
                new QueryWrapper<UmsIntegrationConsumeSettingEntity>()
        );

        return new PageUtils(page);
    }

}