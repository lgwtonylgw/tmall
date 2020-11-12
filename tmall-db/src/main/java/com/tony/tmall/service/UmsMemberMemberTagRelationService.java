package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsMemberMemberTagRelationEntity;

import java.util.Map;

/**
 * 用户和标签关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsMemberMemberTagRelationService extends IService<UmsMemberMemberTagRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

