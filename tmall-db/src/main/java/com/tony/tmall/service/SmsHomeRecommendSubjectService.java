package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsHomeRecommendSubjectEntity;
import com.tony.tmall.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 首页推荐专题表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsHomeRecommendSubjectService extends IService<SmsHomeRecommendSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int create(List<SmsHomeRecommendSubjectEntity> homeBrandList);
}

