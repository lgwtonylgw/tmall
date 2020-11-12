package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 帮助表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Data
@TableName("cms_help")
public class CmsHelpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long categoryId;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Integer showStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer readCount;
	/**
	 * 
	 */
	private String content;

}
