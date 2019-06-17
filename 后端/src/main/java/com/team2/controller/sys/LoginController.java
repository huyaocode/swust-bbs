package com.team2.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;


import com.team2.service.cmt.IMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.base.LoginInfo;
import com.team2.pojo.security.Token;
import com.team2.pojo.sys.LoginUser;
import com.team2.pojo.sys.User;
import com.team2.service.security.TokenService;
import com.team2.service.sys.UserService;
import com.team2.utils.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Api(tags = "登录")
@RestController
@Validated
@RequestMapping("/")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private IMService imService;
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@ApiOperation(value = "登录")
	@PostMapping(value = "/login")
	public void login(@RequestBody LoginInfo loginInfo, HttpServletRequest request, HttpServletResponse response) {
		try {
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginInfo.getUsername(),
					loginInfo.getPassword());
			Authentication authentication = authenticationManager.authenticate(authRequest);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			HttpSession session = request.getSession();
			session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

			LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            Token token = tokenService.saveToken(loginUser);
            //更新IM的token.
			imService.UpdateAccount(String.valueOf(loginUser.getId()),token.getToken());
			ResultResponse<Token> info = new ResultResponse<Token>(token);
			info.setCode(loginUser.getId().intValue());
			ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
			
		} catch (AuthenticationCredentialsNotFoundException e) {
			ResultResponse<String> info = new ResultResponse<String>(-1, "用户不存在!");
			ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
		} catch (DisabledException ex) {
			ResultResponse<String> info = new ResultResponse<String>(-1, "用户被封禁!");
			ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
		} catch (AuthenticationException ex) {
			ResultResponse<String> info = new ResultResponse<String>(-1, "用户名或密码错误!");
			ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
		}
	}

	

}
