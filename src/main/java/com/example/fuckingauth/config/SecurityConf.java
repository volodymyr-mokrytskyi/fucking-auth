package com.example.fuckingauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(2)
public class SecurityConf extends WebSecurityConfigurerAdapter {

	private final BCryptPasswordEncoder encoder;

	public SecurityConf(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.requestMatchers()
			.antMatchers(  "/login**", "/oauth/authorize")
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll();



	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("admin").password(encoder.encode("admin")).roles("USER");

	}


}
