package com.cldt.config.properties;

import lombok.Data;

/**
 * The class Async task properties.
 *
 * @zhoukj
 */
@Data
public class SwaggerProperties {

	private String title;

	private String description;

	private String version = "1.0";

	private String license = "Apache License 2.0";

	private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

	private String contactName = "guandianbao";

	private String contactUrl = "http://www.guandb.com";

	private String contactEmail = "guandianbao@qq.com";
	
    private boolean swaggerShow;
}
