package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsAlbumDao;
import com.tony.tmall.entity.PmsAlbumEntity;
import com.tony.tmall.service.PmsAlbumService;


@Service("pmsAlbumService")
public class PmsAlbumServiceImpl extends ServiceImpl<PmsAlbumDao, PmsAlbumEntity> implements PmsAlbumService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsAlbumEntity> page = this.page(
                new Query<PmsAlbumEntity>().getPage(params),
                new QueryWrapper<PmsAlbumEntity>()
        );

        return new PageUtils(page);
    }

}