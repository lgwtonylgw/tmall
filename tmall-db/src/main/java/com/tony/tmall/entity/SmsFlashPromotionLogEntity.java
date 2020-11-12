package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 限时购通知记录
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("sms_flash_promotion_log")
public class SmsFlashPromotionLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer memberId;
	/**
	 * 
	 */
	private Long productId;
	/**
	 * 
	 */
	private String memberPhone;
	/**
	 * 
	 */
	private String productName;
	/**
	 * 会员订阅时间
	 */
	private Date subscribeTime;
	/**
	 * 
	 */
	private Date sendTime;

}
