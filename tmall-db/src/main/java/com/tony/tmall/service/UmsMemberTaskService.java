package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsMemberTaskEntity;

import java.util.Map;

/**
 * 会员任务表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsMemberTaskService extends IService<UmsMemberTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

