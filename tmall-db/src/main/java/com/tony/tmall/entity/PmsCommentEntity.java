package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品评价表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("pms_comment")
public class PmsCommentEntity implements Serializable {
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
	 * 
	 */
	private String memberNickName;
	/**
	 * 
	 */
	private String productName;
	/**
	 * 评价星数：0->5
	 */
	private Integer star;
	/**
	 * 评价的ip
	 */
	private String memberIp;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer showStatus;
	/**
	 * 购买时的商品属性
	 */
	private String productAttribute;
	/**
	 * 
	 */
	private Integer collectCouont;
	/**
	 * 
	 */
	private Integer readCount;
	/**
	 * 
	 */
	private String content;
	/**
	 * 上传图片地址，以逗号隔开
	 */
	private String pics;
	/**
	 * 评论用户头像
	 */
	private String memberIcon;
	/**
	 * 
	 */
	private Integer replayCount;

}
