package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsAdminLoginLogDao;
import com.tony.tmall.entity.UmsAdminLoginLogEntity;
import com.tony.tmall.service.UmsAdminLoginLogService;


@Service("umsAdminLoginLogService")
public class UmsAdminLoginLogServiceImpl extends ServiceImpl<UmsAdminLoginLogDao, UmsAdminLoginLogEntity> implements UmsAdminLoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsAdminLoginLogEntity> page = this.page(
                new Query<UmsAdminLoginLogEntity>().getPage(params),
                new QueryWrapper<UmsAdminLoginLogEntity>()
        );

        return new PageUtils(page);
    }

}