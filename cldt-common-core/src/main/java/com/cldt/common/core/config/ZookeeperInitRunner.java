package com.cldt.common.core.config;

import java.net.InetAddress;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cldt.config.properties.CldtProperties;
import com.cldt.zk.registry.RegistryCenterFactory;

/**
 * The class Redis init runner.
 *
 * @author paascloud.net @gmail.com
 */
@Component
@Order
@Slf4j
@EnableConfigurationProperties(CldtProperties.class)
public class ZookeeperInitRunner implements CommandLineRunner {
	@Resource
	private CldtProperties guandianbaoProperties;
	@Value("${spring.application.name}")
	private String applicationName;

	/**
	 * Run.
	 *
	 * @param args the args
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {
		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		log.info("###ZookeeperInitRunner，init. HostAddress={}, applicationName={}", hostAddress, applicationName);
		RegistryCenterFactory.startup(guandianbaoProperties, hostAddress, applicationName);
		log.info("###ZookeeperInitRunner，finish<<<<<<<<<<<<<");
	}

}