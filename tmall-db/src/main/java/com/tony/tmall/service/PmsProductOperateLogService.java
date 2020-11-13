package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductOperateLogEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductOperateLogService extends IService<PmsProductOperateLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

