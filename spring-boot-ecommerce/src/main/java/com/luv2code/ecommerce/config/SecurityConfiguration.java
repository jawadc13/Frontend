package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Keep in mind im not using "api" may add it in a later date
		// protect endpoint "api"/orders
		http.authorizeRequests()
			.antMatchers("/orders/**")
			.authenticated()
			.and()
			.oauth2ResourceServer()
			.jwt();
		
		//add CORS filters
		http.cors();
		
		//force a non-empty response body for 401's to make the response more friendly
		//Okta.configureResourceServer401ResponseBody(http);
		
		//diable CSRF since we are not using cookies for session tracking
		http.csrf().disable();
		
	}

}
