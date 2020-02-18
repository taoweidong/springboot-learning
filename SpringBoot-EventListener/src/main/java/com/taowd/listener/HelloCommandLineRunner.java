package com.taowd.listener;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Taoweidong
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("HelloCommandLineRunner is running....." + Arrays.asList(args));
  }
}
