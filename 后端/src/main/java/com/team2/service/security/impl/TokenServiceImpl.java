package com.team2.service.security.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.team2.dao.security.TokenDao;
import com.team2.pojo.security.Token;
import com.team2.pojo.security.TokenModel;
import com.team2.pojo.sys.LoginUser;
import com.team2.service.security.TokenService;
@Primary
@Service
public class TokenServiceImpl implements TokenService{

	/**
	 * token过期秒数
	 */
	@Value("${token.expire.seconds}")
	private Long expireSeconds;
	@Autowired
	private TokenDao tokenDao;
	
	@Override
	public Token saveToken(LoginUser loginUser) {
     String token = UUID.randomUUID().toString();
		
		// 拼装accessToken
//		String token = JwtHelper.createJWT(loginUser.getUsername(), 
//				jwtInfo.getClientId(),
//				jwtInfo.getAudience(), 
//				jwtInfo.getExpiresSecond() * 1000, 
//				jwtInfo.getBase64Secret()); 

		loginUser.setToken(token);
		loginUser.setLoginTime(System.currentTimeMillis());
		loginUser.setExpireTime(loginUser.getLoginTime() + expireSeconds * 1000);

		TokenModel model = new TokenModel();
		model.setToken(token);
		model.setExpireTime(new Date(loginUser.getExpireTime()));
		model.setVal(JSONObject.toJSONString(loginUser));

		tokenDao.save(model);
		return new Token(token, loginUser.getLoginTime());
	}

	@Override
	public LoginUser getLoginUser(String token) {
		TokenModel model = tokenDao.getByToken(token);		
		return toLoginUser(model);
	}
	
	private LoginUser toLoginUser(TokenModel model) {
		if (model == null) {
			return null;
		}
		return JSONObject.parseObject(model.getVal(), LoginUser.class);
	}

}
