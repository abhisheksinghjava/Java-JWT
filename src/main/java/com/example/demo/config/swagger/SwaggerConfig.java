/** COPYRIGHT (C) ABC INDIA PVT.LTD.
 * 
 * ALL RIGHTS RESERVED BY ABC INDIA PVT.LTD., THIS PROGRAM
 * MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
 * FURNISHED BY ABC INDIA PVT.LTD., NO PART OF THIS PROGRAM
 * MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF ABC INDIA PVT.LTD..
 * 
 * ABC INDIA PVT.LTD. CONFIDENTIAL AND PROPRIETARY
 */
package com.example.demo.config.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ApiKey;

/**
 * The Class SwaggerConfig.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description SwaggerConfig class is a swagger config class.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/** The Constant AUTHORIZATION_HEADER. */
	private static final String AUTHORIZATION_HEADER="Authorization";
	
	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
            .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
    }
	
	/**
	 * Api key.
	 *
	 * @return the api key
	 */
	private ApiKey apiKey() {
    	return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }
	
	/**
	 * Security context.
	 *
	 * @return the security context
	 */
	private SecurityContext securityContext() {
    	return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    
    /**
     * Default auth.
     *
     * @return the list
     */
    List<SecurityReference> defaultAuth(){
    	
    	AuthorizationScope authorizationScope=new AuthorizationScope("global", "accessEverything");
    	AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
    	authorizationScopes[0]=authorizationScope;
    	return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    	
    }
	
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("JWT REST API", "Some custom description of API.", "API For JWT", "Terms of service", new Contact("Abhishek Singh", "www.example.com", "abhishek.singh@company.com"), "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
   
}