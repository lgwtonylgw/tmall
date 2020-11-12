package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 运费模版
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("pms_feight_template")
public class PmsFeightTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 计费类型:0->按重量；1->按件数
	 */
	private Integer chargeType;
	/**
	 * 首重kg
	 */
	private BigDecimal firstWeight;
	/**
	 * 首费（元）
	 */
	private BigDecimal firstFee;
	/**
	 * 
	 */
	private BigDecimal continueWeight;
	/**
	 * 
	 */
	private BigDecimal continmeFee;
	/**
	 * 目的地（省、市）
	 */
	private String dest;

}
