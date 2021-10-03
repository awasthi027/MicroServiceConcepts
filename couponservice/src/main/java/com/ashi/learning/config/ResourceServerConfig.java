package com.ashi.learning.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@SuppressWarnings("deprecation")
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String Resource_ID = "couponservice";

	@Value("${public.key}")
	private String publickey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(Resource_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "v1/couponapi/coupon/{code:[A-Z*$]}", "/index", "coupondetails",
						"getcoupon", "coupondetails")
				.hasAnyRole("USER").mvcMatchers(HttpMethod.GET, "/createcoupon", "getcoupon", "couponcreated")
				.hasAnyRole("ADMIN").mvcMatchers(HttpMethod.POST, "v1/couponapi/create/").hasRole("ADMIN");
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtConverter = new JwtAccessTokenConverter();

		jwtConverter.setVerifierKey(publickey);;
		return jwtConverter;
	}

}
