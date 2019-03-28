/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：SocialUserInfo.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.social.support;

import lombok.Data;

/**
 * The class Social user info.
 *
 * @author cldt
 */
@Data
public class SocialUserInfo {

	private String providerId;

	private String providerUserId;

	private String nickname;

	private String headimg;

}
