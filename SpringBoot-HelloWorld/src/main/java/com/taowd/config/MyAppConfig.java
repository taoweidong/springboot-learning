package com.taowd.config;

import com.taowd.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 当前类是配置类，用来替代之前的Spring的配置文件
 * 
 * @author Taoweidong
 */
@Configuration
public class MyAppConfig {

  /**
   * 方法的返回值添加到容器中，容器中的组件名就是方法名
   * 
   * @return 组件
   */
  @Bean
  public HelloService helloService() {
    // 实例化对象
    return new HelloService();
  }

}
