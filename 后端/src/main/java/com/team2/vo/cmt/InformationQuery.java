package com.team2.vo.cmt;

import java.util.Date;

import javax.validation.constraints.Size;

import com.team2.vo.base.BaseParamQuery;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;

public class InformationQuery extends BaseParamQuery {
	@ApiModelProperty(value = "标题(字符长度为1-255)")
	@Size(min = 1, max = 255, message = "标题字符长度为1-255")
	private String title;

	@ApiModelProperty(value = "信息状态0：未交易1：已交易(字符长度为1-1)")
	@Size(min = 1, max = 1, message = "信息状态0：未交易1：已交易字符长度为1-1")
	private String status;

	@ApiModelProperty(value = "类型0：需求1：资源(字符长度为1-1)")
	@Size(min = 1, max = 1, message = "类型0：需求1：资源字符长度为1-1")
	private String type;
	
	@ApiModelProperty(value = "分类的名称")
	private String name;

	@ApiModelProperty(value = "分类id")
	private Long categoryId;

	@ApiModelProperty(value = "用户id")
	private Long userId;

	@ApiModelProperty(value = "当前时间(不用传)")
	private Date endTime;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	

}