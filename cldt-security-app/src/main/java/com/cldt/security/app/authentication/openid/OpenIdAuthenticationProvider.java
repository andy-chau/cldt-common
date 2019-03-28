/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：OpenIdAuthenticationProvider.java

 * 联系方式：cldt@gmail.com

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.app.authentication.openid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;

import java.util.HashSet;
import java.util.Set;

/**
 * The class Open id authentication provider.
 *
 * @author cldt@gmail.com
 */
public class OpenIdAuthenticationProvider implements AuthenticationProvider {

	private SocialUserDetailsService userDetailsService;

	private UsersConnectionRepository usersConnectionRepository;

	/**
	 * Authenticate authentication.
	 *
	 * @param authentication the authentication
	 *
	 * @return the authentication
	 *
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		OpenIdAuthenticationToken authenticationToken = (OpenIdAuthenticationToken) authentication;

		Set<String> providerUserIds = new HashSet<>();
		providerUserIds.add((String) authenticationToken.getPrincipal());
		Set<String> userIds = usersConnectionRepository.findUserIdsConnectedTo(authenticationToken.getProviderId(), providerUserIds);

		if (CollectionUtils.isEmpty(userIds) || userIds.size() != 1) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}

		String userId = userIds.iterator().next();

		UserDetails user = userDetailsService.loadUserByUserId(userId);

		if (user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}

		OpenIdAuthenticationToken authenticationResult = new OpenIdAuthenticationToken(user, user.getAuthorities());

		authenticationResult.setDetails(authenticationToken.getDetails());

		return authenticationResult;
	}

	/**
	 * Supports boolean.
	 *
	 * @param authentication the authentication
	 *
	 * @return the boolean
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return OpenIdAuthenticationToken.class.isAssignableFrom(authentication);
	}

	/**
	 * Gets user details service.
	 *
	 * @return the user details service
	 */
	public SocialUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	/**
	 * Sets user details service.
	 *
	 * @param userDetailsService the user details service
	 */
	public void setUserDetailsService(SocialUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * Gets users connection repository.
	 *
	 * @return the users connection repository
	 */
	public UsersConnectionRepository getUsersConnectionRepository() {
		return usersConnectionRepository;
	}

	/**
	 * Sets users connection repository.
	 *
	 * @param usersConnectionRepository the users connection repository
	 */
	public void setUsersConnectionRepository(UsersConnectionRepository usersConnectionRepository) {
		this.usersConnectionRepository = usersConnectionRepository;
	}

}
