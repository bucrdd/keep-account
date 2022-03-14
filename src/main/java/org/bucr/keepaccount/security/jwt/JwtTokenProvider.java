package org.bucr.keepaccount.security.jwt;

import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

  private JwtProperties jwtProperties;

  private SecretKey secretKey;

  @PostConstruct
  public void init() {
    var secret = Base64.getEncoder().encodeToString(jwtProperties.getSecretKey().getBytes());
    secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

 private String createToken(Authentication authentication) {
   return null;
 }

  private boolean validateToken(String token) {
   return false;
  }
}
