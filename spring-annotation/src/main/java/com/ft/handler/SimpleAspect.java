package com.ft.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
@Aspect
public class SimpleAspect {
    private long reqStartMills;

    @Before(value = "@annotation(com.ft.annotation.Simple)")
    public void beforeMethod(JoinPoint jp) {
        reqStartMills = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String str = "请求时间:" + new Date(reqStartMills) + ",请求的地址:" + request.getRequestURI() + ",请求的方法:" + jp.getSignature().getName();
        System.out.println(str);
    }

    /**
     * 后置增强,方法执行之后执行
     */
    @After(value = "@annotation(com.ft.annotation.Simple)")
    public void afterMethod() {
        System.out.println("耗时:" + (System.currentTimeMillis() - reqStartMills));
    }

    /**
     * 方法返回时执行
     * 
     * @param returnVal
     * @throws IOException
     */
    @AfterReturning(value = "@annotation(com.ft.annotation.Simple)", returning = "returnVal")
    public void returnMethod(Object returnVal) throws IOException {
    }

    /**
     * 环绕增强
     * 
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.ft.annotation.Simple)")
    public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        Map<String, Object> result = new HashMap<>(2);
        try {
            Object proceed = jp.proceed();
            System.out.println("2");
        } catch (Exception e) {
            // throw e; // 其余的异常向上抛,交给web项目的异常处理器来处理
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 出现异常时执行,不过这里不会执行,因为上面的方法已经把异常捕获了
     * 
     * @param error
     */
    @AfterThrowing(value = "@annotation(com.ft.annotation.Simple)", throwing = "error")
    public void exceptionMethod(Throwable error) {
    }
}
