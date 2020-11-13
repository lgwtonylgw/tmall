package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.OmsCompanyAddressEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 公司收发货地址表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface OmsCompanyAddressService extends IService<OmsCompanyAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

