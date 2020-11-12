package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员登录记录
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("ums_member_login_log")
public class UmsMemberLoginLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long memberId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private String city;
	/**
	 * 登录类型：0->PC；1->android;2->ios;3->小程序
	 */
	private Integer loginType;
	/**
	 * 
	 */
	private String province;

}
