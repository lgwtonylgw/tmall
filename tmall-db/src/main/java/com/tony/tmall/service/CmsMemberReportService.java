package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsMemberReportEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 用户举报表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsMemberReportService extends IService<CmsMemberReportEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

