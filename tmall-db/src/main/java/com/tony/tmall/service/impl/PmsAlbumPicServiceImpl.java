package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsAlbumPicDao;
import com.tony.tmall.entity.PmsAlbumPicEntity;
import com.tony.tmall.service.PmsAlbumPicService;


@Service("pmsAlbumPicService")
public class PmsAlbumPicServiceImpl extends ServiceImpl<PmsAlbumPicDao, PmsAlbumPicEntity> implements PmsAlbumPicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsAlbumPicEntity> page = this.page(
                new Query<PmsAlbumPicEntity>().getPage(params),
                new QueryWrapper<PmsAlbumPicEntity>()
        );

        return new PageUtils(page);
    }

}