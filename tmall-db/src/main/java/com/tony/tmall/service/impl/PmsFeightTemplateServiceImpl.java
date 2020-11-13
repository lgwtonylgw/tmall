package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.PmsFeightTemplateDao;
import com.tony.tmall.entity.PmsFeightTemplateEntity;
import com.tony.tmall.service.PmsFeightTemplateService;


@Service("pmsFeightTemplateService")
public class PmsFeightTemplateServiceImpl extends ServiceImpl<PmsFeightTemplateDao, PmsFeightTemplateEntity> implements PmsFeightTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsFeightTemplateEntity> page = this.page(
                new Query<PmsFeightTemplateEntity>().getPage(params),
                new QueryWrapper<PmsFeightTemplateEntity>()
        );

        return new PageUtils(page);
    }

}