/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：OpenIdAuthenticationSecurityConfig.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.app.authentication.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


/**
 * The class Open id authentication security config.
 *
 * @author cldt
 */
@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

	private final AuthenticationFailureHandler pcAuthenticationFailureHandler;

	private final SocialUserDetailsService userDetailsService;

	private final UsersConnectionRepository usersConnectionRepository;

	@Autowired
	public OpenIdAuthenticationSecurityConfig(AuthenticationSuccessHandler pcAuthenticationSuccessHandler, AuthenticationFailureHandler pcAuthenticationFailureHandler, SocialUserDetailsService userDetailsService, UsersConnectionRepository usersConnectionRepository) {
		this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
		this.pcAuthenticationFailureHandler = pcAuthenticationFailureHandler;
		this.userDetailsService = userDetailsService;
		this.usersConnectionRepository = usersConnectionRepository;
	}

	/**
	 * Configure.
	 *
	 * @param http the http
	 */
	@Override
	public void configure(HttpSecurity http) {

		OpenIdAuthenticationFilter openIdAuthenticationFilter = new OpenIdAuthenticationFilter();
		openIdAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		openIdAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
		openIdAuthenticationFilter.setAuthenticationFailureHandler(pcAuthenticationFailureHandler);

		OpenIdAuthenticationProvider openIdAuthenticationProvider = new OpenIdAuthenticationProvider();
		openIdAuthenticationProvider.setUserDetailsService(userDetailsService);
		openIdAuthenticationProvider.setUsersConnectionRepository(usersConnectionRepository);

		http.authenticationProvider(openIdAuthenticationProvider)
				.addFilterAfter(openIdAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
