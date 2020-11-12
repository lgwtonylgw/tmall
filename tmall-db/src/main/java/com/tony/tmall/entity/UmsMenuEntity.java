package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 后台菜单表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("ums_menu")
public class UmsMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 父级ID
	 */
	private Long parentId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 菜单名称
	 */
	private String title;
	/**
	 * 菜单级数
	 */
	private Integer level;
	/**
	 * 菜单排序
	 */
	private Integer sort;
	/**
	 * 前端名称
	 */
	private String name;
	/**
	 * 前端图标
	 */
	private String icon;
	/**
	 * 前端隐藏
	 */
	private Integer hidden;

}
