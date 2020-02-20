package com.taowd.starter;

/**
 * @author Taoweidong
 */
public class HelloService {

  private HelloWorldProperties helloWorldProperties;

  public HelloWorldProperties getHelloWorldProperties() {
    return helloWorldProperties;
  }

  public void setHelloWorldProperties(HelloWorldProperties helloWorldProperties) {
    this.helloWorldProperties = helloWorldProperties;
  }



  public String sayHello(String name) {
    return helloWorldProperties.getPrefix() + name + "" + helloWorldProperties.getSuffix();
  }
}
