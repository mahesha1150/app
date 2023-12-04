package com.metakeep.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.metakeep.app.interceptor.AuditInterceptor;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer{

	@Autowired
	AuditInterceptor auditInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auditInterceptor);
	}
	
//	@Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
//    }
}
