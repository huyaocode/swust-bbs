package com.team2.pojo.base;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class LoginInfo {
	@NotNull
	@ApiModelProperty(value = "用户名")
	String username;
	@NotNull
	@ApiModelProperty(value = "密码")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
