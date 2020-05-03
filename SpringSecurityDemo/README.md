
**1) We can use below code for in memory authentication. With the help of below user details we can login 
to spring security application using pradip@test.com as username and pradip123 as password.
In below code password is kept in encrypted format 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth
		  .inMemoryAuthentication() .passwordEncoder(passwordEncoder)
		  .withUser("pradip@test.com")
		  .password("$2a$10$0M0qdXAs4KuZ99Pf8UyrMOaxDNQ/jmLk3otQeNuIKCRuUhObE8kv2")
		  .roles("ADMIN","USER");
	}
	
	
	
**2)In Spring security application csrf(Cross Site Request Forgery) by default enabled. 
     So You can disable csrf by using below code. 'http' is object of HttpSecurity class.
       http.csrf().disable() 
	