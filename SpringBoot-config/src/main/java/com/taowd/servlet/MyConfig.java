package com.taowd.servlet;

import java.util.Arrays;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
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

  @Bean
  public FilterRegistrationBean myFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new MyFilter());
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myListener() {
    return new ServletListenerRegistrationBean<MyListener>(new MyListener());
  }

}
