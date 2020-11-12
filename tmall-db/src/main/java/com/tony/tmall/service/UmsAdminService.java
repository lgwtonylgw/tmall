package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsAdminEntity;

import java.util.Map;

/**
 * 后台用户表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsAdminService extends IService<UmsAdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

