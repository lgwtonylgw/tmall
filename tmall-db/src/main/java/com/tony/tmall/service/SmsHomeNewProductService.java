package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsHomeNewProductEntity;
import com.tony.tmall.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 新鲜好物表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsHomeNewProductService extends IService<SmsHomeNewProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int create(List<SmsHomeNewProductEntity> homeBrandList);
}

