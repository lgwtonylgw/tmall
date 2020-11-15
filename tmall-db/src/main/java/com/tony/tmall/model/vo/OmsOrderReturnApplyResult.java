package com.tony.tmall.model.vo;

import com.tony.tmall.entity.OmsCompanyAddressEntity;
import com.tony.tmall.entity.OmsOrderReturnApplyEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by tony on 2020/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApplyEntity {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddressEntity companyAddress;
}
