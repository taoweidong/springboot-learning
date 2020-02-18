package com.taowd.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.fastjson.JSON;

/**
 * 自定义监听器<br/>
 * 注意：此处的监听器必须配置在 META-INF/spring.factories文件中
 * 
 * @author Taoweidong
 */
public class HelloApplicationContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    System.out.println("HelloApplicationContextInitializer is runnine .....");
  }
}
