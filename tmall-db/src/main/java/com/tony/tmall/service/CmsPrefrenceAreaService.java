package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsPrefrenceAreaEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 优选专区
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsPrefrenceAreaService extends IService<CmsPrefrenceAreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

