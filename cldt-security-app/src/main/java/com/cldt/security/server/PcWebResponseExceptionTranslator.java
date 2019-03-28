/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：PcWebResponseExceptionTranslator.java

 * 联系方式：cldt@gmail.com

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.server;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * The class Pc web response exception translator.
 *
 * @author cldt @gmail.com
 */
public class PcWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
	/**
	 * Translate response entity.
	 *
	 * @param e the e
	 *
	 * @return the response entity
	 *
	 * @throws Exception the exception
	 */
	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		return null;
	}
}
