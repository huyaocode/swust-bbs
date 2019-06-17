package com.team2.vo.base;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;

public class BaseParamQuery {
	@ApiModelProperty("第几页")
	@Min(1)
	protected Integer pageNum=1;
	
	@ApiModelProperty("分页大小")
	@Min(1)
	protected Integer pageSize=10;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
