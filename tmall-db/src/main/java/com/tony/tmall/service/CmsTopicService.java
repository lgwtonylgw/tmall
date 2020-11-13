package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsTopicEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 话题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsTopicService extends IService<CmsTopicEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

