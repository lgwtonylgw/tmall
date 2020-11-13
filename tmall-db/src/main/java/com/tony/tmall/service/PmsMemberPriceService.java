package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsMemberPriceEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 商品会员价格表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsMemberPriceService extends IService<PmsMemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

