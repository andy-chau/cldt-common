/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：OAuth2Properties.java

 * 联系方式：cldt@gmail.com

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.properties;

import lombok.Data;

/**
 * The class O auth 2 properties.
 *
 * @author cldt @gmail.com
 */
@Data
public class OAuth2Properties {

	/**
	 * 使用jwt时为token签名的秘钥
	 */
	private String jwtSigningKey = "paascloud";
	/**
	 * 客户端配置
	 */
	private OAuth2ClientProperties[] clients = {};

}
