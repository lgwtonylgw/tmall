package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.PmsProductResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品信息
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Mapper
public interface PmsProductDao extends BaseMapper<PmsProductEntity> {

    PmsProductResult getUpdateInfo(Long id);
}
