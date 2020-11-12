package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 专题分类表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Data
@TableName("cms_subject_category")
public class CmsSubjectCategoryEntity implements Serializable {
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
	 * 分类图标
	 */
	private String icon;
	/**
	 * 专题数量
	 */
	private Integer subjectCount;
	/**
	 * 
	 */
	private Integer showStatus;
	/**
	 * 
	 */
	private Integer sort;

}
