package com.taowd.configurer;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TwoInterceptor
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/5 21:15
 * @Version V1.0
 */
public class TwoInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用(Controller方法调用之前)
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(this.getClass().getName() +"[preHandle]-->被Two拦截....放行");
        return true;
    }

    /**
     * 在整个请求结束之后调用，也就是在DispatchServlet渲染了对应的视图之后执行(主要用于进行清理资源的工作)
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(this.getClass().getName()+"[afterCompletion]-->在整个请求结束之后调用，也就是在DispatchServlet渲染了对应的视图之后执行(主要用于进行清理资源的工作)");
    }

    /**
     * 请求调用之后进行调用，但是在视图渲染之前(Controller)方法之后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(this.getClass().getName()+"[postHandle]-->请求执行完毕--->请求调用之后进行调用，但是在视图渲染之前(Controller)方法之后调用");
    }
}
