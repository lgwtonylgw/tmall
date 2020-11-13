package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.PmsProductAttributeValueDao;
import com.tony.tmall.entity.PmsProductAttributeValueEntity;
import com.tony.tmall.service.PmsProductAttributeValueService;


@Service("pmsProductAttributeValueService")
public class PmsProductAttributeValueServiceImpl extends ServiceImpl<PmsProductAttributeValueDao, PmsProductAttributeValueEntity> implements PmsProductAttributeValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductAttributeValueEntity> page = this.page(
                new Query<PmsProductAttributeValueEntity>().getPage(params),
                new QueryWrapper<PmsProductAttributeValueEntity>()
        );

        return new PageUtils(page);
    }

}