/*
 * Copyright (c) 2018. cldt All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：SessionProperties.java
 * 创建人：刘兆明
 * 联系方式：cldt@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.properties;

import lombok.Data;

/**
 * session管理相关配置项
 *
 * @author cldt @gmail.com
 */
@Data
public class SessionProperties {

	/**
	 * 同一个用户在系统中的最大session数，默认1
	 */
	private int maximumSessions = 1;
	/**
	 * 达到最大session时是否阻止新的登录请求，默认为false，不阻止，新的登录会将老的登录失效掉
	 */
	private boolean maxSessionsPreventsLogin;
}