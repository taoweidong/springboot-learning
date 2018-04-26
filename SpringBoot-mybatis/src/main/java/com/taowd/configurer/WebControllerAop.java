package com.taowd.configurer;

import com.alibaba.druid.support.json.JSONUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Taowd
 * @date 2018/4/26 - 13:26
 * @Description 切面类
 */
@Component
@Aspect
public class WebControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(WebControllerAop.class);

    /**
     * 指定切点:匹配com.taowd.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.taowd.controller..*.*(..))")
    public void executeService() {
    }

    /**
     * 前置通知，方法调用前被调用
     * <p>
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

    @AfterReturning(value = "execution(* com.taowd.controller..*.*(..))", returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
        logger.info("第一个后置通知的返回值：" + keys);
    }

    @AfterReturning(value = "execution(* com.taowd.controller..*.*(..))", returning = "keys", argNames = "keys")
    public void doAfterReturningAdvice2(String keys) {

        System.out.println("第二个后置返回通知的返回值：" + keys);
    }

    /**
     * 后置异常通知
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "executeService()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {

        //目标方法名
        logger.info(joinPoint.getSignature().getName());
        if (exception instanceof NullPointerException) {
            logger.info("发生了空指针异常------>XXXXXXXXXXXXXXXXX");
        }
    }

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     *
     * @param joinPoint
     */
    @After("executeService()")
    public void doAfterAdvice(JoinPoint joinPoint) {
        logger.info("后置通知执行了!!!!");
    }

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("execution(* com.taowd.controller..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
