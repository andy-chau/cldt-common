/*
 * Copyright (c) 2018. cldt All Rights Reserved.

 * 类名称：WeixinProperties.java

 * 联系方式：cldt

 * 博客地址: http://blog.cldt
 * 项目官网: http://cldt
 */

package com.cldt.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * 微信登录配置项
 *
 * @author cldt
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WeixinProperties extends SocialProperties {

	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";
}
