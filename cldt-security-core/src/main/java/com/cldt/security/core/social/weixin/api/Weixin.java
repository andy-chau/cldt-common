/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：Weixin.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author cldt
 */
public interface Weixin {

	/**
	 * Gets user info.
	 *
	 * @param openId the open id
	 *
	 * @return the user info
	 */
	WeixinUserInfo getUserInfo(String openId);

}
