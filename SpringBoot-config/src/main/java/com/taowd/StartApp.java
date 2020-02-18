package com.taowd;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Taoweidong
 */
@SpringBootApplication
public class StartApp {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(StartApp.class, args);

    System.out.println(applicationContext.isActive());
    System.out.println(JSON.toJSONString(applicationContext.getEnvironment().getPropertySources()));
    System.out
        .println(JSON.toJSONString(applicationContext.getEnvironment().getSystemEnvironment()));

    System.out.println(applicationContext.getApplicationName());
    System.out.println(applicationContext.getStartupDate());
    System.out.println(applicationContext.getDisplayName());
    System.out.println(applicationContext.getId());

  }
}
