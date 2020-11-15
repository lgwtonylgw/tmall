package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsProductAttributeCategoryDao;
import com.tony.tmall.dao.PmsProductAttributeDao;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.tony.tmall.model.dto.PmsProductAttributeParam;
import com.tony.tmall.model.vo.ProductAttrInfo;
import com.tony.tmall.service.PmsProductAttributeService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("pmsProductAttributeService")
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeDao, PmsProductAttributeEntity> implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeCategoryDao pmsProductAttributeCategoryDao;

    @Autowired
    private PmsProductAttributeDao pmsProductAttributeDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductAttributeEntity> page = this.page(
                new Query<PmsProductAttributeEntity>().getPage(params),
                new QueryWrapper<PmsProductAttributeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public int create(PmsProductAttributeParam productAttributeParam) {
        PmsProductAttributeEntity pmsProductAttribute = new PmsProductAttributeEntity();
        BeanUtils.copyProperties(productAttributeParam, pmsProductAttribute);
        int count = this.baseMapper.insert(pmsProductAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        PmsProductAttributeCategoryEntity pmsProductAttributeCategory = pmsProductAttributeCategoryDao.selectById(pmsProductAttribute.getId());
        if(pmsProductAttribute.getType()==0){
            pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount()+1);
        }else if(pmsProductAttribute.getType()==1){
            pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount()+1);
        }
        pmsProductAttributeCategoryDao.updateById(pmsProductAttributeCategory);
        return count;
    }

    @Override
    @Transactional
    public int delete(List<Long> ids) {
        //获取分类
        PmsProductAttributeEntity pmsProductAttribute = this.baseMapper.selectById(ids.get(0));
        Integer type = pmsProductAttribute.getType();
        PmsProductAttributeCategoryEntity pmsProductAttributeCategory = pmsProductAttributeCategoryDao.selectById(pmsProductAttribute.getProductAttributeCategoryId());
        int count = this.baseMapper.deleteBatchIds(ids);
        //删除完成后修改数量
        if(type==0){
            if(pmsProductAttributeCategory.getAttributeCount()>=count){
                pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount()-count);
            }else{
                pmsProductAttributeCategory.setAttributeCount(0);
            }
        }else if(type==1){
            if(pmsProductAttributeCategory.getParamCount()>=count){
                pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount()-count);
            }else{
                pmsProductAttributeCategory.setParamCount(0);
            }
        }
        pmsProductAttributeCategoryDao.updateById(pmsProductAttributeCategory);
        return count;
    }

    @Override
    public List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return pmsProductAttributeDao.getProductAttrInfo(productCategoryId);
    }
}