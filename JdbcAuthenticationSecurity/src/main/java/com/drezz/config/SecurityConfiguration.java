package com.drezz.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	
	SecurityConfiguration(DataSource dataSource) {
    }
    
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authorization
	@Bean
	public SecurityFilterChain configureAuth(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request->request.requestMatchers("/home","/").permitAll()
						.requestMatchers("/admin").hasAuthority("ADMIN")
						.requestMatchers("/customer").hasAuthority("CUSTOMER")
						.anyRequest().authenticated()
				)
		.formLogin(
//				form->form.loginPage("/login").permitAll()
//				.defaultSuccessUrl("/hello", true)
				);
		return http.build();
	}
	
	//authentication
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource,PasswordEncoder encoder) {
		UserDetails user1  = User.withUsername("khalid")
				.password(encoder.encode("123"))
				.authorities("ADMIN").build();
		
		UserDetails user2  = User.withUsername("ram")
				.password(encoder.encode("1234"))
				.authorities("CUSTOMER").build();
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager();
		users.setDataSource(dataSource);
//		users.createUser(user1);
//		users.createUser(user2);		
		return users;
	}
	
//	@Bean
//	public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//	    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//	    authenticationProvider.setUserDetailsService(userDetailsService);
//	    authenticationProvider.setPasswordEncoder(passwordEncoder);
//	    return authenticationProvider;
//	}
}
