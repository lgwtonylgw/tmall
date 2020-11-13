package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsAdminLoginLogEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 后台用户登录日志表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsAdminLoginLogService extends IService<UmsAdminLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

