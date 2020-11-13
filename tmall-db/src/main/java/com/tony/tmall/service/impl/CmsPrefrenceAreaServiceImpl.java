package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.CmsPrefrenceAreaDao;
import com.tony.tmall.entity.CmsPrefrenceAreaEntity;
import com.tony.tmall.service.CmsPrefrenceAreaService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cmsPrefrenceAreaService")
public class CmsPrefrenceAreaServiceImpl extends ServiceImpl<CmsPrefrenceAreaDao, CmsPrefrenceAreaEntity> implements CmsPrefrenceAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsPrefrenceAreaEntity> page = this.page(
                new Query<CmsPrefrenceAreaEntity>().getPage(params),
                new QueryWrapper<CmsPrefrenceAreaEntity>()
        );

        return new PageUtils(page);
    }

}