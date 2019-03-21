package com.cldt.config;


import com.cldt.config.properties.CldtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class Aliyun core config.
 *
 * @zhoukj
 */
@Configuration
@EnableConfigurationProperties(CldtProperties.class)
public class CldtCoreConfig {
}
