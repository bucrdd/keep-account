package org.bucr.keepaccount.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableKnife4j
public class Knife4jConfig {

  @Bean
  public Docket defaultApi2() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            .description("")
            .termsOfServiceUrl("http://localhost:8080")
            .version("1.0")
            .build())
        .groupName("v2.0")
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.bucr.keepaccount.controller"))
        .paths(PathSelectors.any())
        .build();
  }

}
