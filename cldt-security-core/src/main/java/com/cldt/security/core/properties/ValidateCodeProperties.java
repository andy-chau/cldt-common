/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：ValidateCodeProperties.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.properties;

import lombok.Data;

/**
 * 验证码配置
 *
 * @author cldt @gmail.com
 */
@Data
public class ValidateCodeProperties {

	/**
	 * 图片验证码配置
	 */
	private ImageCodeProperties image = new ImageCodeProperties();
	/**
	 * 短信验证码配置
	 */
	private SmsCodeProperties sms = new SmsCodeProperties();
	/**
	 * 邮箱验证码配置
	 */
	private EmailCodeProperties email = new EmailCodeProperties();

}
