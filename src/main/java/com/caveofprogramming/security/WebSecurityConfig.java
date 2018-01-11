package com.caveofprogramming.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.caveofprogramming.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		/*security rules*/
		http.authorizeRequests()
			.antMatchers("/", "/about", "/register")
				.permitAll()
					.antMatchers("/js/**", "/css/**", "/img/**")
						.permitAll()
							 .antMatchers("/addstatus", "/editstatus", "/deletestatus", "/viewstatus")
							    .hasRole("ADMIN")
									.and()
										.formLogin()
											.loginPage("/login")
												.defaultSuccessUrl("/")
													.permitAll()
													.and()
														.logout()
															.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("jacek").password("jacek").roles("USER");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	

}














































