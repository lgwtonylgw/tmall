package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.OmsCompanyAddressDao;
import com.tony.tmall.entity.OmsCompanyAddressEntity;
import com.tony.tmall.service.OmsCompanyAddressService;


@Service("omsCompanyAddressService")
public class OmsCompanyAddressServiceImpl extends ServiceImpl<OmsCompanyAddressDao, OmsCompanyAddressEntity> implements OmsCompanyAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsCompanyAddressEntity> page = this.page(
                new Query<OmsCompanyAddressEntity>().getPage(params),
                new QueryWrapper<OmsCompanyAddressEntity>()
        );

        return new PageUtils(page);
    }

}