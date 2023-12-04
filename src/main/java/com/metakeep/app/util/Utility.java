package com.metakeep.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.metakeep.app.bean.AuditBean;
import com.metakeep.app.config.AuditStoreConfiguration;


@Component
public class Utility {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuditStoreConfiguration configuration;
	
	public String auditApiCall(AuditBean auditBean) {
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AuditBean> requestEntity = new HttpEntity<>(auditBean, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(configuration.getHost()+"/audit", requestEntity, String.class);

        return null;
		
	}
}
