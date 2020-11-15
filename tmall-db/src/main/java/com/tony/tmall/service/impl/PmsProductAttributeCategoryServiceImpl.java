package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsProductAttributeCategoryDao;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.model.vo.PmsProductAttributeCategoryItem;
import com.tony.tmall.service.PmsProductAttributeCategoryService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("pmsProductAttributeCategoryService")
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryDao, PmsProductAttributeCategoryEntity> implements PmsProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryDao pmsProductAttributeCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductAttributeCategoryEntity> page = this.page(
                new Query<PmsProductAttributeCategoryEntity>().getPage(params),
                new QueryWrapper<PmsProductAttributeCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return pmsProductAttributeCategoryDao.getListWithAttr();
    }

}