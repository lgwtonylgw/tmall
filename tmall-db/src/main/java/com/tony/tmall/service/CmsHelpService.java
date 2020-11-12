package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.CmsHelpEntity;

import java.util.Map;

/**
 * 帮助表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsHelpService extends IService<CmsHelpEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

