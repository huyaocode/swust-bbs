package com.team2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.team2.pojo.security.TokenFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private TokenFilter tokenFilter;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//解决跨域
		http.csrf().disable();
		// 基于token，所以不需要session
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//放行访问
		http.authorizeRequests() 
					.requestMatchers(CorsUtils::isPreFlightRequest).permitAll() 
					.antMatchers("/", "/*.html", "/favicon.ico", "/css/**", 
							"/js/**", "/fonts/**", "/layui/**", "/img/**","/lib/**",
							"/v2/api-docs/**", "/swagger-resources/**",
							"/webjars/**", "/pages/**", "/druid/**",
							"/static/**","/*.xml","/login","/getcaptcha","/user/add",
							"/code/checkcode","/code/sendcode")
						.permitAll()
						.anyRequest().authenticated()
					 .and()
					.formLogin()
					.loginPage("/admin/login")  //定义当需要用户登录时候，转到的登录页面
                    .successForwardUrl("/admin/index")
					.permitAll()
					.and().rememberMe()
                    .and().csrf().disable();
		 
//		http.formLogin().loginPage("/login.do").loginProcessingUrl("/login.do")
//				.successHandler(authenticationSuccessHandler)
//				.failureHandler(authenticationFailureHandler).and()
//				.exceptionHandling()
//				.authenticationEntryPoint(authenticationEntryPoint);
		
		//http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
		// 解决不允许显示在iframe的问题
		http.headers().frameOptions().disable();
		http.headers().cacheControl();
 
		http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
	 
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}


}
