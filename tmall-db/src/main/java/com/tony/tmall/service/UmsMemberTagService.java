package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsMemberTagEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 用户标签表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsMemberTagService extends IService<UmsMemberTagEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

