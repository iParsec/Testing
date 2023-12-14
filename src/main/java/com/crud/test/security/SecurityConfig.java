/*
 * package com.crud.test.security;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.CorsConfigurationSource; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource; import
 * io.jsonwebtoken.Jwts; import io.jsonwebtoken.Claims;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.cors().and().csrf().disable().authorizeRequests()
 * .antMatchers(HttpMethod.POST, "/login").permitAll()
 * .anyRequest().authenticated() .and() .addFilter(new
 * JwtAuthenticationFilter(authenticationManager())) .addFilter(new
 * JwtAuthorizationFilter(authenticationManager()))
 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 * }
 * 
 * @Bean public CorsConfigurationSource corsConfigurationSource() {
 * CorsConfiguration configuration = new CorsConfiguration();
 * configuration.setAllowedOrigins(Arrays.asList("*"));
 * configuration.setAllowedMethods(Arrays.asList("*"));
 * configuration.setAllowedHeaders(Arrays.asList("*"));
 * UrlBasedCorsConfigurationSource source = new
 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
 * configuration); return source; } }
 */