/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：BaseSocialController.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social;

import org.springframework.social.connect.Connection;

import com.cldt.security.core.social.support.SocialUserInfo;


/**
 * The class Social controller.
 *
 * @author cldt
 */
public abstract class BaseSocialController {

	/**
	 * 根据Connection信息构建SocialUserInfo
	 *
	 * @param connection the connection
	 *
	 * @return social user info
	 */
	protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
		SocialUserInfo userInfo = new SocialUserInfo();
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		return userInfo;
	}

}
