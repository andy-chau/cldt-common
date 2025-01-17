/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：QQConnectionFactory.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import com.cldt.security.core.social.qq.api.QQ;

/**
 * The class Qq connection factory.
 *
 * @author cldt
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	/**
	 * Instantiates a new Qq connection factory.
	 *
	 * @param providerId the provider id
	 * @param appId      the app id
	 * @param appSecret  the app secret
	 */
	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
