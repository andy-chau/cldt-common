/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：EmailCodeSender.java

 * 联系方式：cldt@gmail.com

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.validate.code.email;

/**
 * The interface Sms code sender.
 *
 * @author cldt@gmail.com
 */
public interface EmailCodeSender {

	/**
	 * Send.
	 *
	 * @param email the email
	 * @param code  the code
	 */
	void send(String email, String code);

}
