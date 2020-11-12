package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 限时购场次表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("sms_flash_promotion_session")
public class SmsFlashPromotionSessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long id;
	/**
	 * 场次名称
	 */
	private String name;
	/**
	 * 每日开始时间
	 */
	private unknowType startTime;
	/**
	 * 每日结束时间
	 */
	private unknowType endTime;
	/**
	 * 启用状态：0->不启用；1->启用
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
