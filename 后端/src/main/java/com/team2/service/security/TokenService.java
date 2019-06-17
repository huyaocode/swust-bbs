package com.team2.service.security;

import com.team2.pojo.security.Token;
import com.team2.pojo.sys.LoginUser;

public interface TokenService {
	Token saveToken(LoginUser loginUser);
	
	
	LoginUser getLoginUser(String token);

}
