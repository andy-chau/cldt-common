
/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：DefaultEmailCodeSender.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.validate.code.email;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认的短信验证码发送器
 *
 * @author cldt @gmail.com
 */
@Slf4j
public class DefaultEmailCodeSender implements EmailCodeSender {
	/**
	 * Send.
	 *
	 * @param email the mobile
	 * @param code  the code
	 */
	@Override
	public void send(String email, String code) {
		log.warn("请配置真实的邮件验证码发送器(SmsCodeSender)");
		log.info("向邮件" + email + "发送短信验证码" + code);
	}

}
