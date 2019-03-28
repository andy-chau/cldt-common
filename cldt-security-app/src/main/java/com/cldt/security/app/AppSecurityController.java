/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：AppSecurityController.java

 * 联系方式：cldt@gmail.com

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.app;

import com.cldt.security.app.social.AppSingUpUtils;
import com.cldt.security.core.properties.SecurityConstants;
import com.cldt.security.core.social.BaseSocialController;
import com.cldt.security.core.social.support.SocialUserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * The class App security controller.
 *
 * @author cldt@gmail.comg
 */
@RestController
public class AppSecurityController extends BaseSocialController {

	@Resource
	private ProviderSignInUtils providerSignInUtils;

	@Resource
	private AppSingUpUtils appSingUpUtils;

	/**
	 * 需要注册时跳到这里，返回401和用户信息给前端
	 *
	 * @param request the request
	 *
	 * @return social user info
	 */
	@GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
		appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
		return buildSocialUserInfo(connection);
	}

}
