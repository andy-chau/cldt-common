package com.cldt.config.properties;


import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.cldt.base.constant.GlobalConstant;

/**
 * The class cldt properties.
 *
 * @zhoukj
 */
@Data
@Component
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class CldtProperties {
	private ReliableMessageProperties message = new ReliableMessageProperties();
	private AliyunProperties aliyun = new AliyunProperties();
	private AsyncTaskProperties task = new AsyncTaskProperties();
	private SwaggerProperties swagger = new SwaggerProperties();
	private QiniuProperties qiniu = new QiniuProperties();
	private GaodeProperties gaode = new GaodeProperties();
	private JobProperties job = new JobProperties();
	private ZookeeperProperties zk = new ZookeeperProperties();
	
}
