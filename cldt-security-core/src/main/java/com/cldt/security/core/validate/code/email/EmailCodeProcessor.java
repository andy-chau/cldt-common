/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：EmailCodeProcessor.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.validate.code.email;

import com.cldt.security.core.properties.SecurityConstants;
import com.cldt.security.core.validate.code.ValidateCode;
import com.cldt.security.core.validate.code.ValidateCodeGenerator;
import com.cldt.security.core.validate.code.ValidateCodeRepository;
import com.cldt.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 短信验证码处理器
 *
 * @author cldt
 */
@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

	/**
	 * 短信验证码发送器
	 */
	@Resource
	private EmailCodeSender emailCodeSender;

	/**
	 * Instantiates a new Abstract validate code processor.
	 *
	 * @param validateCodeGenerators the validate code generators
	 * @param validateCodeRepository the validate code repository
	 */
	public EmailCodeProcessor(Map<String, ValidateCodeGenerator> validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
		super(validateCodeGenerators, validateCodeRepository);
	}

	/**
	 * Send.
	 *
	 * @param request      the request
	 * @param validateCode the validate code
	 *
	 * @throws Exception the exception
	 */
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_EMAIL;
		String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
		emailCodeSender.send(email, validateCode.getCode());
	}
}
