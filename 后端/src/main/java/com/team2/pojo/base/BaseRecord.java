package com.team2.pojo.base;

import io.swagger.annotations.ApiModelProperty;

public class BaseRecord {
	@ApiModelProperty("基本信息主键id，新建记录无id")
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
