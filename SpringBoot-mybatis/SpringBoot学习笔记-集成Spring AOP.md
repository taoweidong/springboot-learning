# SpringBoot学习笔记-集成Spring AOP

# 学习计划

- 在SpringBoot集成Mybatis之后的项目上进行Spring AOP的集成
- 实现对于Controller的请求拦截，打印请求以及相关返回的日志
- gitHub源码位置：https://github.com/TaciturnK/springboot-learning


# 创建学习工程

此处略过，使用集成Mybatis的工程，https://github.com/TaciturnK/springboot-learning/tree/master/SpringBoot-mybatis

项目结构

![](https://i.imgur.com/JQXwyaG.png)

# 添加依赖

```
<dependency>  
   <groupId>org.springframework.boot</groupId>  
   <artifactId>spring-boot-starter-aop</artifactId>  
</dependency>  
```

# 创建Aspect切面类

AOP的通知类型有：前置通知、后置最终通知、后置返回通知、后置异常通知、环绕通知等，此处对这些通知的添加举例学习下。

```java
@Component  
@Aspect  //注意添加对应的注解
public class WebControllerAop {  

}  
```

# 指定切点

```java
/**
 * 指定切点:匹配com.taowd.controller包及其子包下的所有类的所有方法
 */
@Pointcut("execution(* com.taowd.controller..*.*(..))")
public void executeService() {
}
```

# 前置通知

```java
 /**
     * 前置通知，方法调用前被调用
     *
     * 通过JoinPoint可以获得通知的签名信息，如目标方法名、目标方法参数信息等。通过RequestContextHolder来获取请求信息，Session信息。
     *
     * @param joinpoint
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        logger.info("这里是前置通知");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //Aop代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪个方法
        logger.info("代理的方法：" + signature.getName());
        //AOP代理类的名字
        logger.info("AOP代理类的名字：" + signature.getDeclaringTypeName());
        //AOP代理类的信息
        signature.getDeclaringType();
        //获取RequestAttributes  通过RequestContextHolder来获取请求信息，Session信息。
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取RequestAttributes中HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, String> parameterMap = new HashMap<String, String>();
        while (enumeration.hasMoreElements()) {
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        //使用fastjson将Map对象转成JSON字符串
        String str = JSONUtils.toJSONString(parameterMap);

        logger.info("请求的参数信息为：" + str);

    }
```

注意：这里用到了JoinPoint和RequestContextHolder。通过JoinPoint可以获得通知的签名信息，如目标方法名、目标方法参数信息等。通过RequestContextHolder来获取请求信息，Session信息。

启动工程，访问Controller:http://127.0.0.1:8090//mybatis/queryUserList?nameTest=231313

![](https://i.imgur.com/I3ulNlx.png)

![](https://i.imgur.com/ZG8lFHh.png)

# 后置返回通知

```java
@AfterReturning(value = "execution(* com.taowd.controller..*.*(..))", returning = "keys")
public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
logger.info("第一个后置通知的返回值：" + keys);
}

@AfterReturning(value = "execution(* com.taowd.controller..*.*(..))", returning = "keys", argNames = "keys")
public void doAfterReturningAdvice2(String keys) {

System.out.println("第二个后置返回通知的返回值：" + keys);
}
```

![](https://i.imgur.com/OHL51MI.png)