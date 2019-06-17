package com.team2.pojo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.team2.pojo.sys.LoginUser;
import com.team2.service.security.TokenService;

@Component
public class TokenFilter extends OncePerRequestFilter {

	private static final String TOKEN_KEY = "token";

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserDetailsService userDetailsService;
	private static final Long MINUTES_10 = 10 * 60 * 1000L;

	
	/**
	 * 校验时间<br>
	 * 过期时间与当前时间对比，临近过期10分钟内的话，自动刷新缓存
	 * 
	 * @param loginUser
	 * @return
	 */
//	private LoginUser checkLoginTime(LoginUser loginUser) {
//		long expireTime = loginUser.getExpireTime();
//		long currentTime = System.currentTimeMillis();
//		if (expireTime - currentTime <= MINUTES_10) {
//			String token = loginUser.getToken();
//			loginUser = (LoginUser) userDetailsService.loadUserByUsername(loginUser.getUsername());
//			loginUser.setToken(token);
//			tokenService.refresh(loginUser);
//		}
//		return loginUser;
//	}

	/**
	 * 根据参数或者header获取token
	 * 
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getHeader(TOKEN_KEY);
		if (StringUtils.isBlank(token)) {
			token = request.getParameter(TOKEN_KEY);
		}
		return token;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			javax.servlet.FilterChain filterChain) throws ServletException, IOException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String temp = request.getHeader("Origin");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", temp);
		// 允许的访问方法
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		// Access-Control-Max-Age 用于 CORS 相关配置的缓存
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept,token"); 
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

		
		String token = getToken(request); 

		if (StringUtils.isNotBlank(token)) {
			LoginUser loginUser = tokenService.getLoginUser(token);
			if (loginUser != null) {
				//loginUser = checkLoginTime(loginUser);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser,
						null, loginUser.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
