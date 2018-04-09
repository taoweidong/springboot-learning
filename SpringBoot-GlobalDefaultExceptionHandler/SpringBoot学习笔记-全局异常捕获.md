# 简介

项目开发过程中，一般会对代码中可能出现的异常进行统一处理，前台看到的就是统一可以看得懂的错误信息，而不是什么空指针...这些只有程序员才能看得懂的信息。

# 具体步骤

 * 创建工程：SpringBoot-GlobalDefaultExceptionHandler

![](https://i.imgur.com/bPNPxNT.png)

 * 新建一个Class,这里取名为GlobalDefaultExceptionHandler
 * 在class上添加注解，@ControllerAdvice;
 * 在class中添加一个方法
 * 在方法上添加@ExcetionHandler拦截相应的异常信息；
 * 如果返回的是View -- 方法的返回值是ModelAndView;
 * 如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解.

```java

	/**
	 * 1、新建一个Class,这里取名为GlobalDefaultExceptionHandler
	 * 2、在class上添加注解，@ControllerAdvice;
	 * 3、在class中添加一个方法
	 * 4、在方法上添加@ExcetionHandler拦截相应的异常信息；
	 * 5、如果返回的是View -- 方法的返回值是ModelAndView;
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
	        return "服务器异常，请稍后再试-->";
	    }
	
	}

```

# @ControllerAdvice说明

`@ControllerAdvice`，是Spring3.2提供的新注解，从名字上可以看出大体意思是控制器增强。位置：org.springframework.web.bind.annotation，具体实现如下：

```java
	package org.springframework.web.bind.annotation;
	 
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Component
	public @interface ControllerAdvice {
	 
	@AliasFor("basePackages")
	String[] value() default {};
	 
	@AliasFor("value")
	String[] basePackages() default {};
	 
	Class<?>[] basePackageClasses() default {};
	 
	Class<?>[] assignableTypes() default {};
	 
	Class<? extends Annotation>[] annotations() default {};
```

该注解使用`@Component`注解，这样的话当我们使用`<context:component-scan>`扫描时也能扫描到。

- `@ControllerAdvice`是一个`@Component`，用于定义`@ExceptionHandler`，`@InitBinder`和`@ModelAttribute`方法，适用于所有使用`@RequestMapping`方法。
- Spring4之前，`@ControllerAdvice`在同一调度的Servlet中协助所有控制器。Spring4已经改变：`@ControllerAdvice`支持配置控制器的子集，而默认的行为仍然可以利用。
- 在Spring4中， `@ControllerAdvice`通过`annotations()`, `basePackageClasses()`, `basePackages()`方法定制用于选择控制器子集。

## @ControllerAdvice处理异常

在SpringMVC重要注解（一）`@ExceptionHandler`和`@ResponseStatus`我们提到，如果单使用`@ExceptionHandler`，只能在当前Controller中处理异常。但当配合`@ControllerAdvice`一起使用的时候，就可以摆脱那个限制了。