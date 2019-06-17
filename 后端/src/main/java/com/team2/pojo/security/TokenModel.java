package com.team2.pojo.security;

import java.util.Date;

public class TokenModel {
	String id;
    private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	} 
	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * LoginUser的json串
	 */
	private String val;

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
