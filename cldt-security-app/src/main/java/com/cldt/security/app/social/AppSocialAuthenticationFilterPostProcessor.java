/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：AppSocialAuthenticationFilterPostProcessor.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.app.social;


import com.cldt.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * The type App social authentication filter post processor.
 * @author cldt
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor{

	private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

	@Autowired
	public AppSocialAuthenticationFilterPostProcessor(AuthenticationSuccessHandler pcAuthenticationSuccessHandler) {
		this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
	}

	@Override
	public void process(final SocialAuthenticationFilter socialAuthenticationFilter) {
		socialAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
	}
}
