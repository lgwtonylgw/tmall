package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.model.dto.PmsProductParam;
import com.tony.tmall.model.dto.PmsProductQueryParam;
import com.tony.tmall.model.vo.PmsProductResult;
import com.tony.tmall.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 商品信息
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface PmsProductService extends IService<PmsProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int create(PmsProductParam productParam);

    PmsProductResult getUpdateInfo(Long id);

    int updates(Long id, PmsProductParam productParam);

    Page<PmsProductEntity> listByPage(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);
}

