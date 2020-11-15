package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.SmsCouponDao;
import com.tony.tmall.entity.SmsCouponEntity;
import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;
import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import com.tony.tmall.model.dto.SmsCouponParam;
import com.tony.tmall.service.SmsCouponProductCategoryRelationService;
import com.tony.tmall.service.SmsCouponProductRelationService;
import com.tony.tmall.service.SmsCouponService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("smsCouponService")
public class SmsCouponServiceImpl extends ServiceImpl<SmsCouponDao, SmsCouponEntity> implements SmsCouponService {

    @Autowired
    private SmsCouponDao smsCouponDao;
    @Autowired
    private SmsCouponProductRelationService smsCouponProductRelationService;

    @Autowired
    private SmsCouponProductCategoryRelationService smsCouponProductCategoryRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponEntity> page = this.page(
                new Query<SmsCouponEntity>().getPage(params),
                new QueryWrapper<SmsCouponEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public int create(SmsCouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠券表
        int count = this.baseMapper.insert(couponParam);
        //插入优惠券和商品关系表
        if (couponParam.getUseType().equals(2)) {
            for (SmsCouponProductRelationEntity productRelation : couponParam.getProductRelationList()) {
                productRelation.setCouponId(couponParam.getId());
            }
            smsCouponProductRelationService.saveBatch(couponParam.getProductRelationList());
        }
        //插入优惠券和商品分类关系表
        if (couponParam.getUseType().equals(1)) {
            for (SmsCouponProductCategoryRelationEntity couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            smsCouponProductCategoryRelationService.saveBatch(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    @Transactional
    public int delete(Long id) {
        //删除优惠券
        int count = this.baseMapper.deleteById(id);
        //删除商品关联
        deleteProductRelation(id);
        //删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    @Override
    @Transactional
    public int updateByid(Long id, SmsCouponParam couponParam) {
        couponParam.setId(id);
        int count =this.baseMapper.updateById(couponParam);
        //删除后插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(SmsCouponProductRelationEntity productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            smsCouponProductRelationService.saveBatch(couponParam.getProductRelationList());
        }
        //删除后插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (SmsCouponProductCategoryRelationEntity couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            smsCouponProductCategoryRelationService.saveBatch(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    private void deleteProductCategoryRelation(Long id) {

        smsCouponProductCategoryRelationService.remove(new LambdaQueryWrapper<SmsCouponProductCategoryRelationEntity>().eq(SmsCouponProductCategoryRelationEntity::getCouponId, id));
    }

    private void deleteProductRelation(Long id) {
        smsCouponProductRelationService.remove(new LambdaQueryWrapper<SmsCouponProductRelationEntity>().eq(SmsCouponProductRelationEntity::getCouponId, id));
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return smsCouponDao.getItem(id);
    }
}