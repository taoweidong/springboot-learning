package com.taowd.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Taoweidong
 */
@ConfigurationProperties(prefix = "taowd.hello")
public class HelloWorldProperties {

  private String prefix;
  private String suffix;

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
