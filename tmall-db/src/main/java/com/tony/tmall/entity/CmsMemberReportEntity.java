package com.tony.tmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户举报表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Data
@TableName("cms_member_report")
public class CmsMemberReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 举报类型：0->商品评价；1->话题内容；2->用户评论
	 */
	private Integer reportType;
	/**
	 * 举报人
	 */
	private String reportMemberName;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String reportObject;
	/**
	 * 举报状态：0->未处理；1->已处理
	 */
	private Integer reportStatus;
	/**
	 * 处理结果：0->无效；1->有效；2->恶意
	 */
	private Integer handleStatus;
	/**
	 * 
	 */
	private String note;

}
