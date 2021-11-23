package com.nostra.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nostra.demo.security.filter.JwtTokenAuthenticationProcessingFilter;
import com.nostra.demo.security.filter.UsernamePasswordAuthProcessingFilter;
import com.nostra.demo.security.provider.JWTAuthenticationProvider;
import com.nostra.demo.security.provider.UsernamePasswordAuthProvider;
import com.nostra.demo.security.util.SkipPathRequestMatcher;
import com.nostra.demo.security.util.TokenExtractor;
import com.nostra.demo.service.AppUserService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String V1_URL = "/v1/**";
    public static final String AUTHENTICATION_URL = "/v1/login";

	
//	@Autowired
//	private AppUserService appUserService;
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;
	
    @Autowired 
    private AuthenticationSuccessHandler successHandler;

    @Autowired 
    private UsernamePasswordAuthProvider usernamePasswordAuthProvider;
    
	@Autowired
	private JWTAuthenticationProvider jwtAuthenticationProvider;   
    
    
    @Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired 
    private ObjectMapper objectMapper;
    
	@Autowired
	private TokenExtractor tokenExtractor;
    
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.  (appUserService).passwordEncoder(passwordEncoder());
		auth.authenticationProvider(usernamePasswordAuthProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);

	}
	
	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(
			List<String> pathsToSkip, List<String> patternList)  {
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, patternList);
		JwtTokenAuthenticationProcessingFilter filter = new JwtTokenAuthenticationProcessingFilter(failureHandler,
				tokenExtractor, matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	protected UsernamePasswordAuthProcessingFilter buildUsernamePasswordProcessingFilter(String loginEntryPoint)  {
		UsernamePasswordAuthProcessingFilter filter = new UsernamePasswordAuthProcessingFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		List<String> permitAllEndpointList = Arrays.asList(
				AUTHENTICATION_URL,
				"/actuator/**",
				"/console", 
				"/h2-console/**", 
				"/swagger-resources/**",
				"/swagger-ui.html", 
				"/v2/api-docs", 
				"/webjars/**"
		);
		List<String> aunthenticatedEndpointList = Arrays.asList(
				V1_URL
		);
		
		http
		.csrf().disable()
		.headers().frameOptions().disable()
//		.and().authorizeRequests().anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
    	.authorizeRequests().antMatchers(V1_URL).authenticated()
    	.and()
        .addFilterBefore(buildUsernamePasswordProcessingFilter(AUTHENTICATION_URL), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(permitAllEndpointList,
                aunthenticatedEndpointList), UsernamePasswordAuthenticationFilter.class);;

//		.httpBasic();
	}

	
	
	
}
