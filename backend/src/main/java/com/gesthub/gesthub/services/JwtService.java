package com.gesthub.gesthub.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

  private static final String SECRET_KEY = "JXdoz3nFNknrUXNqDjTqFbh3Z2xFHSXK";

  public String extractEmail(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T>claimResolver) {
    Claims claims = extractAllClaims(token);
    return claimResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
          .parser()
          .setSigningKey(getSignInKey())
          .parseClaimsJws(token)
          .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String generateToken(
    Map<String, Object> claims,
    UserDetails userDetails
  ) {
    return Jwts
      .builder()
      .setClaims(claims)
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
      .signWith(getSignInKey(), SignatureAlgorithm.ES256)
      .compact();
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String email = extractEmail(token);
      return email.equals(userDetails.getUsername());
  }

  public boolean isTokenExpired(String token) {
    return extractExpirationDate(token).before(new Date());
  }

  private Date extractExpirationDate(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
}
