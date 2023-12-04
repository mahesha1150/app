package com.metakeep.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("auditstore")
public class AuditStoreConfiguration {
	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
