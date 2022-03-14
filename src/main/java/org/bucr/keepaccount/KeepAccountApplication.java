package org.bucr.keepaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KeepAccountApplication {

  public static void main(String[] args) {
    SpringApplication.run(KeepAccountApplication.class, args);
  }

}
