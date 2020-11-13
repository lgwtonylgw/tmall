package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsHomeAdvertiseEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 首页轮播广告表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsHomeAdvertiseService extends IService<SmsHomeAdvertiseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

