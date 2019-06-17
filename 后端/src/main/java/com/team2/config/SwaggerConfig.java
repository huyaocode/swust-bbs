package com.team2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//spring会自动把这个类实例化成一个bean注册到spring上下文中
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	static List<Parameter> getParamList(){
		List<Parameter>parameters=new ArrayList<Parameter>();
		ParameterBuilder tokenPar=new ParameterBuilder();
		tokenPar.name("token").description("令牌")
		        .modelRef(new ModelRef("string"))
		        .parameterType("header")
		        .required(false)
		        .build();
		
		parameters.add(tokenPar.build());
		return parameters;
	}
	
	@Bean
	public Docket sysDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("系统基础功能")
				.apiInfo(new ApiInfoBuilder().title("系统基础功能-接口文档")
				 .build())
				.select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.team2.controller.sys"))
				.build()
				.globalOperationParameters(SwaggerConfig.getParamList());

	}
	
	@Bean
	public Docket cmtDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("来找我主要功能")
				.apiInfo(new ApiInfoBuilder().title("来找我主要功能-接口文档")
				.build())
				.select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.team2.controller.cmt"))
				.build()
				.globalOperationParameters(SwaggerConfig.getParamList());

	}

}
