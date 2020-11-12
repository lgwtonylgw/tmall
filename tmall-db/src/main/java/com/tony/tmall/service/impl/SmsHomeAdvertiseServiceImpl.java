package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.SmsHomeAdvertiseDao;
import com.tony.tmall.entity.SmsHomeAdvertiseEntity;
import com.tony.tmall.service.SmsHomeAdvertiseService;


@Service("smsHomeAdvertiseService")
public class SmsHomeAdvertiseServiceImpl extends ServiceImpl<SmsHomeAdvertiseDao, SmsHomeAdvertiseEntity> implements SmsHomeAdvertiseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeAdvertiseEntity> page = this.page(
                new Query<SmsHomeAdvertiseEntity>().getPage(params),
                new QueryWrapper<SmsHomeAdvertiseEntity>()
        );

        return new PageUtils(page);
    }

}