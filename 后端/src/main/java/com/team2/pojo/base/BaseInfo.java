package com.team2.pojo.base;

import com.team2.vo.base.BaseParamQuery;

import io.swagger.annotations.ApiModelProperty;

public class BaseInfo{
	@ApiModelProperty(value = "信息类型0：需求1：资源")
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
