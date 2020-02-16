package com.taowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource(value = {"classpath:beans.xml"}) :导入外部的spring配置文件
 * @author Taoweidong
 */
@SpringBootApplication
// @ImportResource(value = {"classpath:beans.xml"})
public class SpringbootHelloApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootHelloApplication.class, args);
  }

}
