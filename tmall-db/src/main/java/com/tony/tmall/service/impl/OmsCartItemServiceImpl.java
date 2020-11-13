package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.OmsCartItemDao;
import com.tony.tmall.entity.OmsCartItemEntity;
import com.tony.tmall.service.OmsCartItemService;


@Service("omsCartItemService")
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemDao, OmsCartItemEntity> implements OmsCartItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsCartItemEntity> page = this.page(
                new Query<OmsCartItemEntity>().getPage(params),
                new QueryWrapper<OmsCartItemEntity>()
        );

        return new PageUtils(page);
    }

}