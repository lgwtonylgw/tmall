package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsProductCategoryDao;
import com.tony.tmall.dao.PmsProductDao;
import com.tony.tmall.entity.PmsProductCategoryAttributeRelationEntity;
import com.tony.tmall.entity.PmsProductCategoryEntity;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.model.dto.PmsProductCategoryParam;
import com.tony.tmall.model.vo.PmsProductCategoryWithChildrenItem;
import com.tony.tmall.service.PmsProductCategoryAttributeRelationService;
import com.tony.tmall.service.PmsProductCategoryService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("pmsProductCategoryService")
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryDao, PmsProductCategoryEntity> implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    @Autowired
    private PmsProductDao pmsProductDao;


    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductCategoryEntity> page = this.page(
                new Query<PmsProductCategoryEntity>().getPage(params),
                new QueryWrapper<PmsProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public int create(PmsProductCategoryParam productCategoryParam) {
        PmsProductCategoryEntity productCategory = new PmsProductCategoryEntity();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = this.baseMapper.insert(productCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = productCategoryParam.getProductAttributeIdList();
        if(!CollectionUtils.isEmpty(productAttributeIdList)){
            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

    @Override
    @Transactional
    public int updates(Long id, PmsProductCategoryParam productCategoryParam) {
        PmsProductCategoryEntity productCategory = new PmsProductCategoryEntity();
        productCategory.setId(id);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        PmsProductEntity product = new PmsProductEntity();
        product.setProductCategoryName(productCategory.getName());
        pmsProductDao.update(product,
                new LambdaQueryWrapper<PmsProductEntity>().eq(PmsProductEntity::getProductCategoryId,id));
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(productCategoryParam.getProductAttributeIdList())){
            pmsProductCategoryAttributeRelationService.remove(new LambdaQueryWrapper<PmsProductCategoryAttributeRelationEntity>()
            .eq(PmsProductCategoryAttributeRelationEntity::getProductCategoryId,id));
            insertRelationList(id,productCategoryParam.getProductAttributeIdList());
        }else{
            pmsProductCategoryAttributeRelationService.remove(new LambdaQueryWrapper<PmsProductCategoryAttributeRelationEntity>()
                    .eq(PmsProductCategoryAttributeRelationEntity::getProductCategoryId,id));
        }
        return pmsProductCategoryDao.updateById(productCategory);

    }

    /**
     * 批量插入商品分类与筛选属性关系表
     * @param productCategoryId 商品分类id
     * @param productAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<PmsProductCategoryAttributeRelationEntity> relationList = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            PmsProductCategoryAttributeRelationEntity relation = new PmsProductCategoryAttributeRelationEntity();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        pmsProductCategoryAttributeRelationService.saveBatch(relationList);
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(PmsProductCategoryEntity productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategoryEntity parentCategory = this.baseMapper.selectById(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }


    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryDao.listWithChildren();
    }
}