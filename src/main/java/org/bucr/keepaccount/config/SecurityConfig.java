package org.bucr.keepaccount.config;

import org.bucr.keepaccount.repository.UserRepository;
import org.bucr.keepaccount.security.RestAccessDeniedHandler;
import org.bucr.keepaccount.security.jwt.JwtAuthenticationEntryPoint;
import org.bucr.keepaccount.security.jwt.JwtSecurityConfigurer;
import org.bucr.keepaccount.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain springWebFilterChain(HttpSecurity http, JwtTokenProvider tokenProvider) throws Exception {
    return http
        .httpBasic().disable()
        .csrf().disable()
        .authorizeHttpRequests()
        .antMatchers("/favicon.ico").permitAll()
        .antMatchers("/doc.html", "/webjars/**", "/swagger-resources/**", "/v2/api-docs/**").permitAll()
        .antMatchers("/auth/login").permitAll()
        .antMatchers("/auth/signup").permitAll()
        .antMatchers("/role/list").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .apply(new JwtSecurityConfigurer(tokenProvider))
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
        .accessDeniedHandler(new RestAccessDeniedHandler())
        .and()
        .build();
  }

  @Bean
  UserDetailsService customUserDetailsService(UserRepository users) {
    return username -> users.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found."));
  }

  @Bean
  AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
    return authentication -> {
      String username = authentication.getPrincipal() + "";
      String password = authentication.getCredentials() + "";

      UserDetails user = userDetailsService.loadUserByUsername(username);

      if (!encoder.matches(password, user.getPassword())) {
        throw new BadCredentialsException("Bad credentials");
      }

      if (!user.isEnabled()) {
        throw new DisabledException("User account is not active");
      }

      return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
    };
  }
}
