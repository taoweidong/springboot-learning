package com.taowd.controller;

import com.alibaba.fastjson.JSON;
import com.taowd.bean.Person;
import com.taowd.bean.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Taowd
 * @date 2018/3/23 - 17:08
 * @Description
 */
@RestController
public class HelloWorldController {

  @Autowired
  private Person person;

  @Autowired
  private Person2 person2;

  @GetMapping("/")
  public String hello() {
    return "Hello World SpringBoot person---->" + JSON.toJSONString(person);
  }

  @GetMapping("/getPerson2")
  public String getPerson2() {
    return "Hello World SpringBoot person2---->" + JSON.toJSONString(person2);
  }

}
