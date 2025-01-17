 /*
  * Copyright (c) 2018. cldt All Rights Reserved.
 
  * 类名称：TokenStoreConfig.java
 
  * 联系方式：cldt
 
  * 博客地址: http://blog.cldt
  * 项目官网: http://cldt
  */

 package com.cldt.security.server;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.cldt.security.core.properties.SecurityProperties;


/**
 * The class Token store config.
 *
 * @author cldt
 */
@Configuration
public class TokenStoreConfig {

	/**
	 * 使用redis存储token的配置，只有在cldt.security.oauth2.tokenStore配置为redis时生效
	 */
	@Configuration
	@ConditionalOnProperty(prefix = "cldt.security.oauth2", name = "tokenStore", havingValue = "redis")
	public static class RedisConfig {

		@Autowired
		private RedisConnectionFactory redisConnectionFactory;

		/**
		 * Redis token store token store.
		 *
		 * @return token store
		 */
		@Bean
		public TokenStore redisTokenStore() {
			return new RedisTokenStore(redisConnectionFactory);
		}

	}

	/**
	 * 使用jwt时的配置，默认生效
	 *
	 * @author cldt
	 */
	@Configuration
	@ConditionalOnProperty(prefix = "cldt.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
	public static class JwtConfig {

		@Autowired
		private SecurityProperties securityProperties;

		/**
		 * Jwt token store token store.
		 *
		 * @return the token store
		 */
		@Bean
		public TokenStore jwtTokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter());
		}

		/**
		 * Jwt access token converter jwt access token converter.
		 *
		 * @return the jwt access token converter
		 */
		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			converter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
			return converter;
		}

		/**
		 * Jwt token enhancer token enhancer.
		 *
		 * @return the token enhancer
		 */
		@Bean
		@ConditionalOnBean(TokenEnhancer.class)
		public TokenEnhancer jwtTokenEnhancer() {
			return new TokenJwtEnhancer();
		}

	}


}
