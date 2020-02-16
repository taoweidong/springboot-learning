package com.taowd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Taowd
 * @date 2018/3/23 - 17:08
 * @Description
 */
@RestController
public class HelloWorldController {


  @GetMapping("/")
  public String hello() {
    return "Hello World SpringBoot person---->";
  }



}
