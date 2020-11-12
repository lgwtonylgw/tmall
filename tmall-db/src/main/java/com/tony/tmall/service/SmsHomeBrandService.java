package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.SmsHomeBrandEntity;

import java.util.Map;

/**
 * 首页推荐品牌表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsHomeBrandService extends IService<SmsHomeBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

