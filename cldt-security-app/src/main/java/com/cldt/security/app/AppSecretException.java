/*
 * Copyright (c) 2018. cldt All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：AppSecretException.java
 * 创建人：刘兆明
 * 联系方式：cldt@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.app;

/**
 * The class App secret exception.
 *
 * @author cldt @gmail.com
 */
public class AppSecretException extends RuntimeException {

	private static final long serialVersionUID = -1629364510827838114L;

	/**
	 * Instantiates a new App secret exception.
	 *
	 * @param msg the msg
	 */
	public AppSecretException(String msg) {
		super(msg);
	}

}
