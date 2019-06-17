package com.team2.pojo.base;

import javax.validation.constraints.NotNull;

import com.team2.vo.base.BaseParamQuery;

import io.swagger.annotations.ApiModelProperty;

public class SearchInfo extends BaseParamQuery{
	@NotNull
	@ApiModelProperty(value = "搜索内容")
	String searchContent;
	
	@ApiModelProperty(value = "信息类型0：需求1：资源")
	String type;

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
