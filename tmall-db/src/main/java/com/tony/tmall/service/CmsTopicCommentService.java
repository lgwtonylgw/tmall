package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsTopicCommentEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 专题评论表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsTopicCommentService extends IService<CmsTopicCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

