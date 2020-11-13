package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductLadderEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 产品阶梯价格表(只针对同商品)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductLadderService extends IService<PmsProductLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

