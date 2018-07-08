package com.market.config.cors;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
@Configuration
public class Oauth2CorsFilter extends OncePerRequestFilter {

	private final CorsProperties corsProperties;

	private DefaultCorsProcessor defaultCorsProcessor;

	@PostConstruct
	private void initialize(){
		defaultCorsProcessor = new DefaultCorsProcessor();
	}

	@Bean
	public CorsConfiguration corsConfiguration(){
			CorsConfiguration corsConfig = new CorsConfiguration();
			corsConfig.setAllowedOrigins(corsProperties.getAllowedOrigins());
			corsConfig.setAllowedHeaders(corsProperties.getAllowedHeaders());
			corsConfig.setAllowedMethods(corsProperties.getAllowedMethods());
			corsConfig.setMaxAge(3600L);
			corsConfig.applyPermitDefaultValues();
		return corsConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		defaultCorsProcessor.processRequest(corsConfiguration(), request, response);
		if (!HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
			filterChain.doFilter(request, response);
		}
	}
}
