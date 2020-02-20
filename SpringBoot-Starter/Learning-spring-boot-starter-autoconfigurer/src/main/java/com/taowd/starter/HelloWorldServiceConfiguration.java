package com.taowd.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Taoweidong
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloWorldProperties.class)
public class HelloWorldServiceConfiguration {

  @Autowired
  private HelloWorldProperties helloWorldProperties;

  @Bean
  public HelloService helloService() {
    HelloService helloService = new HelloService();
    helloService.setHelloWorldProperties(helloWorldProperties);
    return helloService;
  }

}
