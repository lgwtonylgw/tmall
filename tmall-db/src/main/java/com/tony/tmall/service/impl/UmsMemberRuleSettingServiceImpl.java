package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsMemberRuleSettingDao;
import com.tony.tmall.entity.UmsMemberRuleSettingEntity;
import com.tony.tmall.service.UmsMemberRuleSettingService;


@Service("umsMemberRuleSettingService")
public class UmsMemberRuleSettingServiceImpl extends ServiceImpl<UmsMemberRuleSettingDao, UmsMemberRuleSettingEntity> implements UmsMemberRuleSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberRuleSettingEntity> page = this.page(
                new Query<UmsMemberRuleSettingEntity>().getPage(params),
                new QueryWrapper<UmsMemberRuleSettingEntity>()
        );

        return new PageUtils(page);
    }

}