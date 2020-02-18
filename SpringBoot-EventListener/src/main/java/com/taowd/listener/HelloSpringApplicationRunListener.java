package com.taowd.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Spring自定义监听器<br/>
 * 注意：此处的监听器必须配置在 META-INF/spring.factories文件中
 * 
 * @author Taoweidong
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

  public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {

  }

  /**
   * IOC容器创建之前
   */
  @Override
  public void starting() {
    System.out.println("HelloSpringApplicationRunListener is running.....");
  }

  /**
   * IOC容器环境参数准备
   * 
   * @param environment
   */
  @Override
  public void environmentPrepared(ConfigurableEnvironment environment) {
    System.out.println("HelloSpringApplicationRunListener.environmentPrepared"
        + environment.getSystemEnvironment());

  }

  /**
   * IOC容器准备好之后执行的
   * 
   * @param context
   */
  @Override
  public void contextPrepared(ConfigurableApplicationContext context) {

  }

  /**
   * IOC容器参数加载完成
   * 
   * @param context
   */
  @Override
  public void contextLoaded(ConfigurableApplicationContext context) {

  }

  @Override
  public void started(ConfigurableApplicationContext context) {

  }

  @Override
  public void running(ConfigurableApplicationContext context) {

  }

  @Override
  public void failed(ConfigurableApplicationContext context, Throwable exception) {

  }
}
