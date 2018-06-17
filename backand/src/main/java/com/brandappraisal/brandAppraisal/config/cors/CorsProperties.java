package com.brandappraisal.brandAppraisal.config.cors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "oauth2.cors")
@Getter
@Setter
public class CorsProperties {

	private List<String> allowedOrigins;

	private List<String> allowedMethods;

	private List<String> allowedHeaders;
}
