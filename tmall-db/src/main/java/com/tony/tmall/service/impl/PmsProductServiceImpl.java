package com.tony.tmall.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.PmsProductDao;
import com.tony.tmall.entity.*;
import com.tony.tmall.model.dto.PmsProductParam;
import com.tony.tmall.model.dto.PmsProductQueryParam;
import com.tony.tmall.model.vo.PmsProductResult;
import com.tony.tmall.service.*;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("pmsProductService")
@Slf4j
public class PmsProductServiceImpl extends ServiceImpl<PmsProductDao, PmsProductEntity> implements PmsProductService {


    @Autowired
    private PmsProductDao pmsProductDao;
    @Autowired
    private PmsMemberPriceService pmsMemberPriceService;

    @Autowired
    private PmsProductLadderService pmsProductLadderService;

    @Autowired
    private PmsProductFullReductionService pmsProductFullReductionService;

    @Autowired
    private PmsSkuStockService pmsSkuStockService;

    @Autowired
    private PmsProductAttributeValueService pmsProductAttributeValueService;

    @Autowired
    private CmsSubjectProductRelationService cmsSubjectProductRelationService;

    @Autowired
    private CmsPrefrenceAreaProductRelationService cmsPrefrenceAreaProductRelationService;
    @Autowired
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductEntity> page = this.page(
                new Query<PmsProductEntity>().getPage(params),
                new QueryWrapper<PmsProductEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public int create(PmsProductParam productParam) {
        int count;
        //创建商品
        PmsProductEntity product = productParam;
        product.setId(null);
        this.baseMapper.insert(product);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        List<PmsMemberPriceEntity> memberPriceList = productParam.getMemberPriceList();
        memberPriceList.forEach(i -> i.setProductId(productId));
        pmsMemberPriceService.saveBatch(memberPriceList);
        //阶梯价格
        List<PmsProductLadderEntity> productLadderList = productParam.getProductLadderList();
        productLadderList.forEach(i -> i.setProductId(productId));
        pmsProductLadderService.saveBatch(productLadderList);
        //满减价格
        List<PmsProductFullReductionEntity> productFullReductionList = productParam.getProductFullReductionList();
        productFullReductionList.forEach(i -> i.setProductId(productId));
        pmsProductFullReductionService.saveBatch(productFullReductionList);
        //处理sku的编码
        handleSkuStockCode(productParam.getSkuStockList(), productId);
        //添加sku库存信息
        List<PmsSkuStockEntity> skuStockList = productParam.getSkuStockList();
        skuStockList.forEach(i -> i.setProductId(productId));
        pmsSkuStockService.saveBatch(skuStockList);
        //添加商品参数,添加自定义商品规格
        List<PmsProductAttributeValueEntity> productAttributeValueList = productParam.getProductAttributeValueList();
        productAttributeValueList.forEach(i -> i.setProductId(productId));
        pmsProductAttributeValueService.saveBatch(productAttributeValueList);
        //关联专题
        List<CmsSubjectProductRelationEntity> subjectProductRelationList = productParam.getSubjectProductRelationList();
        subjectProductRelationList.forEach(i -> i.setProductId(productId));
        cmsSubjectProductRelationService.saveBatch(subjectProductRelationList);
        //关联优选
        List<CmsPrefrenceAreaProductRelationEntity> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        prefrenceAreaProductRelationList.forEach(i -> i.setProductId(productId));
        cmsPrefrenceAreaProductRelationService.saveBatch(prefrenceAreaProductRelationList);
        count = 1;
        return count;
    }

    private void handleSkuStockCode(List<PmsSkuStockEntity> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList)) return;
        for (int i = 0; i < skuStockList.size(); i++) {
            PmsSkuStockEntity skuStock = skuStockList.get(i);
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i + 1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return pmsProductDao.getUpdateInfo(id);
    }

    @Override
    @Transactional
    public int updates(Long id, PmsProductParam productParam) {
        int count;
        //更新商品信息
        PmsProductEntity product = productParam;
        product.setId(id);
        this.baseMapper.updateById(product);
        //会员价格

        pmsMemberPriceService.remove(new LambdaQueryWrapper<PmsMemberPriceEntity>().eq(PmsMemberPriceEntity::getProductId, id));
        List<PmsMemberPriceEntity> memberPriceList = productParam.getMemberPriceList();
        memberPriceList.forEach(i -> i.setProductId(id));
        pmsMemberPriceService.saveBatch(memberPriceList);
        //阶梯价格

        pmsProductLadderService.remove(new LambdaQueryWrapper<PmsProductLadderEntity>().eq(PmsProductLadderEntity::getProductId, id));
        List<PmsProductLadderEntity> productLadderList = productParam.getProductLadderList();
        productLadderList.forEach(i -> i.setProductId(id));
        pmsProductLadderService.saveBatch(productLadderList);
        //满减价格

        pmsProductFullReductionService.remove(new LambdaQueryWrapper<PmsProductFullReductionEntity>().eq(PmsProductFullReductionEntity::getProductId, id));
        List<PmsProductFullReductionEntity> productFullReductionList = productParam.getProductFullReductionList();
        productFullReductionList.forEach(i -> i.setProductId(id));
        pmsProductFullReductionService.saveBatch(productFullReductionList);
        //修改sku库存信息
        handleUpdateSkuStockList(id, productParam);
        //修改商品参数,添加自定义商品规格

        pmsProductAttributeValueService.remove(new LambdaQueryWrapper<PmsProductAttributeValueEntity>().eq(PmsProductAttributeValueEntity::getProductId, id));
        List<PmsProductAttributeValueEntity> productAttributeValueList = productParam.getProductAttributeValueList();
        productAttributeValueList.forEach(i -> i.setProductId(id));
        pmsProductAttributeValueService.saveBatch(productAttributeValueList);
        //关联专题
        cmsSubjectProductRelationService.remove(new LambdaQueryWrapper<CmsSubjectProductRelationEntity>().eq(CmsSubjectProductRelationEntity::getProductId, id));
        List<CmsSubjectProductRelationEntity> subjectProductRelationList = productParam.getSubjectProductRelationList();
        subjectProductRelationList.forEach(i -> i.setProductId(id));
        cmsSubjectProductRelationService.saveBatch(subjectProductRelationList);
        //关联优选

        cmsPrefrenceAreaProductRelationService.remove(new LambdaQueryWrapper<CmsPrefrenceAreaProductRelationEntity>().eq(CmsPrefrenceAreaProductRelationEntity::getProductId, id));
        List<CmsPrefrenceAreaProductRelationEntity> prefrenceAreaProductRelationList = productParam.getPrefrenceAreaProductRelationList();
        prefrenceAreaProductRelationList.forEach(i -> i.setProductId(id));
        cmsPrefrenceAreaProductRelationService.saveBatch(prefrenceAreaProductRelationList);
        count = 1;
        return count;
    }

    private void handleUpdateSkuStockList(Long id, PmsProductParam productParam) {
        //当前的sku信息
        List<PmsSkuStockEntity> currSkuList = productParam.getSkuStockList();
        //当前没有sku直接删除
        if (CollUtil.isEmpty(currSkuList)) {
            pmsSkuStockService.remove(new LambdaQueryWrapper<PmsSkuStockEntity>().eq(PmsSkuStockEntity::getProductId, id));
            return;
        }
        //获取初始sku信息
        List<PmsSkuStockEntity> oriStuList = pmsSkuStockService.list(new LambdaQueryWrapper<PmsSkuStockEntity>().eq(PmsSkuStockEntity::getProductId, id));
        //获取新增sku信息
        List<PmsSkuStockEntity> insertSkuList = currSkuList.stream().filter(item -> item.getId() == null).collect(Collectors.toList());
        //获取需要更新的sku信息
        List<PmsSkuStockEntity> updateSkuList = currSkuList.stream().filter(item -> item.getId() != null).collect(Collectors.toList());
        List<Long> updateSkuIds = updateSkuList.stream().map(PmsSkuStockEntity::getId).collect(Collectors.toList());
        //获取需要删除的sku信息
        List<PmsSkuStockEntity> removeSkuList = oriStuList.stream().filter(item -> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
        handleSkuStockCode(insertSkuList, id);
        handleSkuStockCode(updateSkuList, id);
        //新增sku
        if (CollUtil.isNotEmpty(insertSkuList)) {
            insertSkuList.forEach(i -> i.setProductId(id));
            pmsSkuStockService.saveBatch(insertSkuList);

        }
        //删除sku
        if (CollUtil.isNotEmpty(removeSkuList)) {
            List<Long> removeSkuIds = removeSkuList.stream().map(PmsSkuStockEntity::getId).collect(Collectors.toList());
            pmsSkuStockService.removeByIds(removeSkuIds);
        }
        //修改sku
        if (CollUtil.isNotEmpty(updateSkuList)) {
            for (PmsSkuStockEntity pmsSkuStock : updateSkuList) {
                pmsSkuStockService.updateById(pmsSkuStock);
            }
        }

    }

    @Override
    public Page<PmsProductEntity> listByPage(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        Page<PmsProductEntity> page = new Page<PmsProductEntity>(pageNum, pageSize);
        LambdaQueryWrapper<PmsProductEntity> wrapper = new LambdaQueryWrapper<PmsProductEntity>();
        wrapper.eq(PmsProductEntity::getDeleteStatus,0);
        if (productQueryParam.getPublishStatus() != null) {
            wrapper.eq(PmsProductEntity::getPublishStatus,productQueryParam.getPublishStatus());
        }
        if (productQueryParam.getVerifyStatus() != null) {
            wrapper.eq(PmsProductEntity::getVerifyStatus,productQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            wrapper.like(PmsProductEntity::getName,productQueryParam.getKeyword());
        }
        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            wrapper.eq(PmsProductEntity::getProductSn,productQueryParam.getProductSn());
        }
        if (productQueryParam.getBrandId() != null) {
            wrapper.eq(PmsProductEntity::getBrandId,productQueryParam.getBrandId());
        }
        if (productQueryParam.getProductCategoryId() != null) {
            wrapper.eq(PmsProductEntity::getProductCategoryId,productQueryParam.getProductCategoryId());
        }
        return pmsProductDao.selectPage(page,wrapper);
    }

    @Override
    @Transactional
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        PmsProductEntity product = new PmsProductEntity();
        product.setVerifyStatus(verifyStatus);
        List<PmsProductVertifyRecordEntity> list = new ArrayList<>();
        int count = pmsProductDao.update(product, new LambdaQueryWrapper<PmsProductEntity>()
                .in(PmsProductEntity::getId, ids));
        //修改完审核状态后插入审核记录
        for (Long id : ids) {
            PmsProductVertifyRecordEntity record = new PmsProductVertifyRecordEntity();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setDetail(detail);
            record.setStatus(verifyStatus);
            record.setVertifyMan("test");
            list.add(record);
        }
        pmsProductVertifyRecordService.saveBatch(list);
        return count;
    }


    /**
     * 建立和插入关系表操作
     *
     * @param dao       可以操作的dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            log.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}