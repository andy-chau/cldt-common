package com.cldt.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 *
 * @author cldt
 */
public interface ValidateCodeGenerator {

	/**
	 * 生成校验码
	 *
	 * @param request the request
	 *
	 * @return validate code
	 */
	ValidateCode generate(ServletWebRequest request);

}
