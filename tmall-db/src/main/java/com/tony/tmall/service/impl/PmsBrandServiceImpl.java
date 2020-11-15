package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsBrandDao;
import com.tony.tmall.dao.PmsProductDao;
import com.tony.tmall.entity.PmsBrandEntity;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.model.dto.PmsBrandParam;
import com.tony.tmall.service.PmsBrandService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("pmsBrandService")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrandEntity> implements PmsBrandService {

    @Autowired
    private PmsProductDao pmsProductDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsBrandEntity> page = this.page(
                new Query<PmsBrandEntity>().getPage(params),
                new QueryWrapper<PmsBrandEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    @Transactional
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        PmsBrandEntity pmsBrand = new PmsBrandEntity();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        PmsProductEntity product = new PmsProductEntity();
        product.setBrandName(pmsBrand.getName());
        pmsProductDao.update(product,new LambdaQueryWrapper<PmsProductEntity>().eq(PmsProductEntity::getBrandId,id));
        return this.baseMapper.updateById(pmsBrand);
    }
}