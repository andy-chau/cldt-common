/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：EmailCodeGenerator.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.validate.code.email;

import com.cldt.security.core.properties.SecurityProperties;
import com.cldt.security.core.validate.code.ValidateCode;
import com.cldt.security.core.validate.code.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 短信验证码生成器
 *
 * @author cldt
 */
@Slf4j
@Component("emailValidateCodeGenerator")
public class EmailCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * Generate validate code.
	 *
	 * @param request the request
	 *
	 * @return the validate code
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
		String[] emails = parameterMap.get("email");
		log.info(Arrays.toString(emails));
		String code = Arrays.toString(emails);
		return new ValidateCode(code, securityProperties.getCode().getEmail().getExpireIn());
	}
}
