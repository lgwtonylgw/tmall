package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.PmsFeightTemplateEntity;

import java.util.Map;

/**
 * 运费模版
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsFeightTemplateService extends IService<PmsFeightTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

