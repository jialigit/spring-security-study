package hello.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	UserDetailsService userDetailsService;

	//BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConfig(UserDetailsService userDetailsService
			//, BCryptPasswordEncoder bCryptPasswordEncoder
			) {
		this.userDetailsService = userDetailsService;

		//this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	
	@Override
	public void configure(HttpSecurity http)throws Exception {
		
		
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "users/signup").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.addFilter(new JWTLoginFilter(authenticationManager()))
		//.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		;
		
		
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        //.passwordEncoder(bCryptPasswordEncoder);
    }

 

}
