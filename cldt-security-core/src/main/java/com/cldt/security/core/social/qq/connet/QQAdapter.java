/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：QQAdapter.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social.qq.connet;

import com.cldt.security.core.social.qq.api.QQ;
import com.cldt.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * The class Qq adapter.
 *
 * @author cldt
 */
public class QQAdapter implements ApiAdapter<QQ> {

	/**
	 * Test boolean.
	 *
	 * @param api the api
	 *
	 * @return the boolean
	 */
	@Override
	public boolean test(QQ api) {
		return true;
	}

	/**
	 * Sets connection values.
	 *
	 * @param api    the api
	 * @param values the values
	 */
	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();

		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureUrlQq1());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}

	/**
	 * Fetch user profile user profile.
	 *
	 * @param api the api
	 *
	 * @return the user profile
	 */
	@Override
	public UserProfile fetchUserProfile(QQ api) {
		return null;
	}

	/**
	 * Update status.
	 *
	 * @param api     the api
	 * @param message the message
	 */
	@Override
	public void updateStatus(QQ api, String message) {
		//do noting
	}

}
