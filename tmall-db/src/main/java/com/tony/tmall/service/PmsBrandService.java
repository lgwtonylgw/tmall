package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsBrandEntity;
import com.tony.tmall.model.dto.PmsBrandParam;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 品牌表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface PmsBrandService extends IService<PmsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int updateBrand(Long id, PmsBrandParam pmsBrandParam);
}

