/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：AppSecretException.java

 * 联系方式：cldt

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
