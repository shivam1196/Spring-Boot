package com.shivam.users.socialmedia.config;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .paths(PathSelectors.any())
        .apis(RequestHandlerSelectors.any())
        .build().useDefaultResponseMessages(true);
  }

  private ApiInfo apiInfo(){
    return new ApiInfo("Dogs Api","This is a Social Media Rest Api for Students and Tech Geeks",
        "version 1.0","",new Contact(
        "Shivam Srivastav","","sumancrown101@gmail.com"
    ),"License of Api","", Collections.emptyList());
  }
}
