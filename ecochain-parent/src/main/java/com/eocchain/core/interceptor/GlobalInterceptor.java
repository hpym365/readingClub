package com.eocchain.core.interceptor;

import com.eocchain.core.annotation.AppLoginVerify;
import com.eocchain.core.annotation.LoginVerify;
import com.eocchain.core.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;

/**
 * @Author: Haben
 * @Description: 用户session登录验证
 * @Date: 2017-08-26 20:26
 * @Version: 1.0
 **/
@Component
public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Annotation[] annotations = method.getMethod().getDeclaredAnnotations();
            LoginVerify loginVerify = method.getMethodAnnotation(LoginVerify.class);
            AppLoginVerify appLoginVerify = method.getMethodAnnotation(AppLoginVerify.class);
            // 如果方法有登录验证注解 则判断是否有session存在
            if (appLoginVerify != null || loginVerify != null) {
                HttpSession session = request.getSession();
                if (session != null) {
                    return true;
                } else {
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().print(Result.failed("未登录"));
                    response.getWriter().close();
                    return false;
                }
            } else {
                return true;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
