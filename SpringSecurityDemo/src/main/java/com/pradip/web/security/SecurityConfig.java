package com.pradip.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	 
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	   

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().mvcMatchers("/*.css", "/*.js");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("index.html").permitAll()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("USER")
		//.anyRequest().hasAnyRole("USER").and()
		.antMatchers("/account/**").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/account/home")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout") //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout=true")
		.invalidateHttpSession(true)
		.permitAll()
		.and()
		.rememberMe()
		.rememberMeParameter("checkRememberMe");
		
	}
}
