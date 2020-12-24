package com.nagarro.techassignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nagarro.techassignment.filter.LoginPageFilter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.addFilterBefore(new LoginPageFilter(), UsernamePasswordAuthenticationFilter.class);
    	
        http.authorizeRequests()
        .antMatchers("/accounts/{accountId}").hasAnyRole("USER", "ADMIN")
        .antMatchers("/accounts/{accountId}/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
//        .defaultSuccessUrl("/welcome", true)
        .defaultSuccessUrl("/accounts/1", true)
        .and()
        .logout().permitAll();
        
		
	
}
                
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("testUser")
                .password("{noop}userpassword")
                .roles("USER")
                .and()
                .withUser("testadmin")
                .password("{noop}adminpassword")
                .roles("ADMIN");
    }
}
