/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：WeixinAdapter.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social.weixin.connect;

import com.cldt.security.core.social.weixin.api.WeixinUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.cldt.security.core.social.weixin.api.Weixin;

/**
 * 微信 api适配器，将微信 api的数据模型转为spring social的标准模型。
 *
 * @author cldt
 */
public class WeixinAdapter implements ApiAdapter<Weixin> {

	private String openId;

	/**
	 * Instantiates a new Weixin adapter.
	 */
	WeixinAdapter() {
	}

	/**
	 * Instantiates a new Weixin adapter.
	 *
	 * @param openId the open id
	 */
	WeixinAdapter(String openId) {
		this.openId = openId;
	}

	/**
	 * Test boolean.
	 *
	 * @param api the api
	 *
	 * @return boolean boolean
	 */
	@Override
	public boolean test(Weixin api) {
		return true;
	}

	/**
	 * Sets connection values.
	 *
	 * @param api    the api
	 * @param values the values
	 */
	@Override
	public void setConnectionValues(Weixin api, ConnectionValues values) {
		WeixinUserInfo profile = api.getUserInfo(openId);
		values.setProviderUserId(profile.getOpenid());
		values.setDisplayName(profile.getNickname());
		values.setImageUrl(profile.getHeadimgurl());
	}

	/**
	 * Fetch user profile user profile.
	 *
	 * @param api the api
	 *
	 * @return user profile
	 */
	@Override
	public UserProfile fetchUserProfile(Weixin api) {
		return null;
	}

	/**
	 * Update status.
	 *
	 * @param api     the api
	 * @param message the message
	 */
	@Override
	public void updateStatus(Weixin api, String message) {
		//do nothing
	}

}
