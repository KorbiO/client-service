package com.example.demo.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/commande/**").permitAll();
        http.authorizeRequests().antMatchers("/venteflash/**").permitAll();
        http.authorizeRequests().antMatchers("/commande/**").permitAll();
        http.authorizeRequests().antMatchers("/reclamation/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers("/avis/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/client/**").permitAll();
        http.authorizeRequests().antMatchers("/article/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/marque/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/categorie/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/souscategorie/**").permitAll();
       
       
        
      
       
        http.authorizeRequests().anyRequest().authenticated();
       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
