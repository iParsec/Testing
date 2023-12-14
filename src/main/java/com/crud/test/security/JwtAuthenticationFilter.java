/*
 * package com.crud.test.security;
 * 
 * import java.io.IOException; import java.sql.Date; import java.util.ArrayList;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.security.web.authentication.www.
 * BasicAuthenticationFilter;
 * 
 * import com.crud.test.entities.User; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jwts; import
 * io.jsonwebtoken.SignatureAlgorithm; import jakarta.servlet.FilterChain;
 * import jakarta.servlet.ServletException; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * public class JwtAuthenticationFilter extends
 * UsernamePasswordAuthenticationFilter {
 * 
 * private static final long EXPIRATION_TIME = 0; private static final String
 * SECRET = null; private static final String TOKEN_PREFIX = null; private
 * static final String HEADER_STRING = null; private AuthenticationManager
 * authenticationManager;
 * 
 * public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
 * this.authenticationManager = authenticationManager; }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException { try {
 * UserCredentials creds = new
 * ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);
 * return authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken( creds.getUsername(),
 * creds.getPassword(), new ArrayList<>()) ); } catch (IOException e) { throw
 * new RuntimeException(e); } }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException { String token = Jwts.builder()
 * .setSubject(((User) authResult.getPrincipal()).getUsername())
 * .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
 * .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()) .compact();
 * response.addHeader(HEADER_STRING, TOKEN_PREFIX + token); } }
 * 
 * 
 * public class JwtAuthorizationFilters extends BasicAuthenticationFilter {
 * 
 * private static final String HEADER_STRING = null; private static final String
 * TOKEN_PREFIX = null; private static final String SECRET = null;
 * 
 * public JwtAuthorizationFilterz(AuthenticationManager authenticationManager) {
 * super(authenticationManager); }
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain) throws IOException,
 * ServletException { String header = request.getHeader(HEADER_STRING);
 * 
 * if (header == null || !header.startsWith(TOKEN_PREFIX)) {
 * chain.doFilter(request, response); return; }
 * 
 * UsernamePasswordAuthenticationToken authentication =
 * getAuthentication(request);
 * 
 * SecurityContextHolder.getContext().setAuthentication(authentication);
 * chain.doFilter(request, response); }
 * 
 * private UsernamePasswordAuthenticationToken
 * getAuthentication(HttpServletRequest request) { String token =
 * request.getHeader(HEADER_STRING); if (token != null) { // parse the token.
 * Claims claims = Jwts.parser() .setSigningKey(SECRET.getBytes())
 * .parseClaimsJws(token.replace(TOKEN_PREFIX, "")) .getBody();
 * 
 * String user = claims.getSubject();
 * 
 * if (user != null) { return new UsernamePasswordAuthenticationToken(user,
 * null, new ArrayList<>()); } return null; } return null; } }
 */