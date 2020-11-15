package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.UmsAdminDao;
import com.tony.tmall.entity.UmsAdminEntity;
import com.tony.tmall.service.UmsAdminService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("umsAdminService")
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminDao, UmsAdminEntity> implements UmsAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsAdminEntity> page = this.page(
                new Query<UmsAdminEntity>().getPage(params),
                new QueryWrapper<UmsAdminEntity>()
        );

        return new PageUtils(page);
    }

}