package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsSubjectEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 专题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsSubjectService extends IService<CmsSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

