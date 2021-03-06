package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsHomeBrandEntity;
import com.tony.tmall.util.PageUtils;

import java.util.List;
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

    int create(List<SmsHomeBrandEntity> homeBrandList);
}

