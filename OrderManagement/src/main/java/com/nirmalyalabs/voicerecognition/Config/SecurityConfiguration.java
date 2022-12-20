package com.nirmalyalabs.voicerecognition.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nirmalyalabs.voicerecognition.Service.Impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	public MyUserDetailsService myuserDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(myuserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// rules should be defined from most specific to most general
		http.authorizeRequests()
		    .antMatchers("/api/users").access("hasRole('ADMIN')")
		    .antMatchers("/api/addUserForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/saveUser").access("hasRole('ADMIN')")
		    .antMatchers("/api/showUserUpdateForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/showUserDeletForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/customers").access("hasRole('ADMIN')")
		    .antMatchers("/api/addCustomerForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/saveCustomer").access("hasRole('ADMIN')")
		    .antMatchers("/api/showCustomerUpdateForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/showCustomerDeleteForm").access("hasRole('ADMIN')")
		    .antMatchers("/api/items").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/addItemForm").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/saveItem").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/showItemUpdateForm").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/showItemDeleteForm").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/orders").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/addorder").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/saveorder").access("hasRole('USER') or hasRole('ADMIN')")
		    .antMatchers("/api/showOrder").access("hasRole('USER') or hasRole('ADMIN')")
            .anyRequest().authenticated()
			.and()
			       .formLogin().loginPage("/api/login")
			       .defaultSuccessUrl("/api/index", true) // the second parameter is for enforcing this url always
	               .loginProcessingUrl("/login")
	               .failureUrl("/api/login?error")
			       .usernameParameter("userid").passwordParameter("password")
			       .permitAll()
			.and()
			       .logout().logoutUrl("/doLogout").logoutSuccessUrl("/api/logout")
			       .permitAll()
			.and()
			       .csrf();
		http.authenticationProvider(authenticationProvider());
		http.headers().frameOptions().sameOrigin();

		return http.build();
	}


	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> 
	    web.ignoring()
	      .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**");
	}
	
}
