package com.team2.pojo;

import io.swagger.annotations.ApiModelProperty;

public class ResultResponse<T extends Object> {
	@ApiModelProperty(value="错误码(0:成功 1:失败)")
	private int code;
	@ApiModelProperty(value="详细信息")
	private String message;
	@ApiModelProperty(value="返回数据")
	private T data;
	
	public ResultResponse(int c,String m) {
		code=c;
		message=m;	
	}
	
	public ResultResponse(int c,String m,T o) {
		code=c;
		message=m;
		data=o;
	}
	
	public ResultResponse(String m) {
		code=0;
		message=m;
		data=null;
	}
	
	public ResultResponse(T o) {
		code=0;
		message="OK";
		data=o;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	

}
