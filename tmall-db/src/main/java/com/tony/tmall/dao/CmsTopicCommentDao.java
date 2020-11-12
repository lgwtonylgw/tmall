package com.tony.tmall.dao;

import com.tony.tmall.entity.CmsTopicCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 专题评论表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Mapper
public interface CmsTopicCommentDao extends BaseMapper<CmsTopicCommentEntity> {
	
}
