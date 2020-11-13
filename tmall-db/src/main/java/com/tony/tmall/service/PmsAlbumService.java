package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsAlbumEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 相册表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface PmsAlbumService extends IService<PmsAlbumEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

