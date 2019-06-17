package com.team2.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.team2.pojo.sys.LoginUser;

public class UserUtil { 
	public static LoginUser getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			return (LoginUser) authentication.getPrincipal();
		} 
		//LoginUser  user = new LoginUser();
		//user.setId(1L);
		//return user;
		return null;
	} 
}
