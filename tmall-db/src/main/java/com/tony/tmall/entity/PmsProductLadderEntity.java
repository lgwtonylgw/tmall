package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 产品阶梯价格表(只针对同商品)
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("pms_product_ladder")
public class PmsProductLadderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long productId;
	/**
	 * 满足的商品数量
	 */
	private Integer count;
	/**
	 * 折扣
	 */
	private BigDecimal discount;
	/**
	 * 折后价格
	 */
	private BigDecimal price;

}
