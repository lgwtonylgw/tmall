package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员任务表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Data
@TableName("ums_member_task")
public class UmsMemberTaskEntity implements Serializable {
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
	 * 赠送成长值
	 */
	private Integer growth;
	/**
	 * 赠送积分
	 */
	private Integer intergration;
	/**
	 * 任务类型：0->新手任务；1->日常任务
	 */
	private Integer type;

}
