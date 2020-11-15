package com.tony.tmall.model.dto;

import com.tony.tmall.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 创建和修改商品时使用的参数
 * Created by tony on 2020/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProductEntity {
    @ApiModelProperty("商品阶梯价格设置")
    private List<PmsProductLadderEntity> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<PmsProductFullReductionEntity> productFullReductionList;
    @ApiModelProperty("商品会员价格设置")
    private List<PmsMemberPriceEntity> memberPriceList;
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStockEntity> skuStockList;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<PmsProductAttributeValueEntity> productAttributeValueList;
    @ApiModelProperty("专题和商品关系")
    private List<CmsSubjectProductRelationEntity> subjectProductRelationList;
    @ApiModelProperty("优选专区和商品的关系")
    private List<CmsPrefrenceAreaProductRelationEntity> prefrenceAreaProductRelationList;
}
