package com.team2.pojo.base;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ReportInfo {
	@NotNull
	@ApiModelProperty(value = "举报id")
	Long id;
	
	@ApiModelProperty(value = "0：不封禁1：封禁")
	String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
