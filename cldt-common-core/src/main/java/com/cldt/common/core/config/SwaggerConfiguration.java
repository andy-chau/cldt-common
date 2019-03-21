package com.cldt.common.core.config;

import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.cldt.config.properties.CldtProperties;
import com.cldt.config.properties.SwaggerProperties;

/**
 * The class Swagger configuration.
 *
 * @author paascloud.net@gmail.com
 */
@EnableSwagger2
@EnableConfigurationProperties(CldtProperties.class)
public class SwaggerConfiguration {
	@Resource
	private CldtProperties guandianbaoProperties;

	/**
	 * Reservation api docket.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .enable(guandianbaoProperties.getSwagger().isSwaggerShow())
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build().enable(true);
	}

	private ApiInfo apiInfo() {
		SwaggerProperties swagger = guandianbaoProperties.getSwagger();
		return new ApiInfoBuilder()
				.title(swagger.getTitle())
				.description(swagger.getDescription())
				.version(swagger.getVersion())
//				.license(swagger.getLicense())
//				.licenseUrl(swagger.getLicenseUrl())
				.contact(new Contact(swagger.getContactName(), swagger.getContactUrl(), swagger.getContactEmail()))
				.build();
	}
}