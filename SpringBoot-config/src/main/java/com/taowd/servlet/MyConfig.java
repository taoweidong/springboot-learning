package com.taowd.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Taoweidong
 */
@Configuration
public class MyConfig {

  /**
   * 注册三大组件
   * 
   * @return
   */
  @Bean
  public ServletRegistrationBean myServlet() {
    return new ServletRegistrationBean(new MyServlet(), "/myServlet");
  }

}
