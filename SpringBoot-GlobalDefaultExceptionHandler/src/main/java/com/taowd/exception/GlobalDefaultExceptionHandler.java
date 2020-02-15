package com.taowd.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 1、新建一个Class,这里取名为GlobalDefaultExceptionHandler 2、在class上添加注解，@ControllerAdvice; 3、在class中添加一个方法
 * 4、在方法上添加@ExcetionHandler拦截相应的异常信息； 5、如果返回的是View -- 方法的返回值是ModelAndView;
 * 6、如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解.
 *
 * @author Taowd
 * @date 2018/4/9 - 21:54
 * @Description
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
    // e.printStackTrace();

    // 优化，防止自定义异常无法捕获的的问题
    // if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
    // throw e;
    // }

    // ModelAndView -- 介绍 模板引擎...?
    // ModelAndView mv = new ModelAndView();
    // mv.setViewName(viewName);

    return "服务器异常，请稍后再试-->" + e.getMessage() + "\n";
  }

}
