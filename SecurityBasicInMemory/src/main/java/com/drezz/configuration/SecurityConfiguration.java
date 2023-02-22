package com.drezz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
//@EnableMethodSecurity
public class SecurityConfiguration {
	
	//authentication
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin=User.withUsername("md")
			.password(encoder.encode("md"))
			.roles("ADMIN")
			.build();
		UserDetails user=User.withUsername("anish")
			.password(encoder.encode("123"))
			.roles("USER")
			.build();
		return new InMemoryUserDetailsManager(admin,user);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	
	 return  httpSecurity.csrf()
//			.disable()
//			.authorizeHttpRequests()
//			.requestMatchers("/welcome","/products")
//			.permitAll()
//			.and()
//			.authorizeHttpRequests()
//			.requestMatchers("/products/**")
//			.authenticated()
//			.and()
			.disable().
			authorizeHttpRequests(
					request -> request.requestMatchers("/","/home")
					.permitAll()
					.anyRequest().authenticated()
					)
				.formLogin( form -> form.loginPage("/login").permitAll() )
				.logout( logout -> logout.permitAll())
			.build();
   }
}
