package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductVertifyRecordEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 商品审核记录
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductVertifyRecordService extends IService<PmsProductVertifyRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

