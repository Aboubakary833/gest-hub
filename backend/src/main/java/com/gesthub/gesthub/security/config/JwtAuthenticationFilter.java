package com.gesthub.gesthub.security.config;

import com.gesthub.gesthub.services.JwtService;
import com.gesthub.gesthub.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private JwtService jwtService;
  private UserService userService;

  @Override
  protected void doFilterInternal(
    @NonNull HttpServletRequest request,
    @NonNull HttpServletResponse response,
    @NonNull FilterChain filterChain) throws ServletException, IOException {
    final String authToken = request.getHeader("Authorization");
    final String jwtToken;
    final String userEmail;
    if (authToken == null || !authToken.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    jwtToken = authToken.substring(7);
    userEmail = jwtService.extractEmail(jwtToken);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      final UserDetails user = userService.loadUserByUsername(userEmail);
      if (jwtService.isTokenValid(jwtToken, user)) {
        UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(
          user,
          null,
          user.getAuthorities()
        );
        userAuthToken.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(
            request
          )
        );

        SecurityContextHolder.getContext().setAuthentication(userAuthToken);
      }
    }
  }
}
