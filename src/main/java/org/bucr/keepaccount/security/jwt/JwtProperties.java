package org.bucr.keepaccount.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

  private String secretKey = "secret-key-for-application";

  private Long validateInMs = 3600000L; // 1h
}
