package com.team2.vo.cmt;

import javax.validation.constraints.Size;

import com.team2.vo.base.BaseParamQuery;

import io.swagger.annotations.ApiModelProperty;


public class HotSearchQuery extends BaseParamQuery{
	@ApiModelProperty(value = "热度名词(字符长度为1-255)")
	@Size(min=1, max=255,message="热度名词字符长度为1-255")
	private String hotWord;

	public String getHotWord() {
		return hotWord;
	}

	public void setHotWord(String hotWord) {
		this.hotWord = hotWord;
	}
	
	
}