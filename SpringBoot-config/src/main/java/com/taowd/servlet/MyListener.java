package com.taowd.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Taoweidong
 */
public class MyListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized----->web应用启动");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed----->web应用销毁");
  }
}
