package com.hit.eryi.infrastructure.aspect;

import com.alibaba.fastjson.JSON;
import com.hit.eryi.infrastructure.utils.EmptyUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName : WebLogAspect
 * @Description:
 * @Date : 2018-07-12 13:40
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    ThreadLocal<String> uuidRequest = new ThreadLocal<>();

    @Pointcut("@annotation(com.hit.eryi.infrastructure.aspect.WebLog)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            String uuid = UUID.randomUUID().toString();
            uuidRequest.set(uuid);
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            startTime.set(System.currentTimeMillis());
            log.info("【controller日志】请求 uuid : {} ，url : {} , http_method :{} , IP : {} , class_method : {} , args : {}" ,
                    uuid,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    request.getRemoteAddr(),
                    joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                    JSON.toJSONString(joinPoint.getArgs())

            );
        } catch (Exception e) {
            log.error("weblog doBefore Exception,cause = {}",e);
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String url = request.getRequestURL().toString();
            if(EmptyUtil.isNotEmpty(url) && EmptyUtil.isNotEmpty(startTime) && EmptyUtil.isNotEmpty(uuidRequest.get()) && EmptyUtil.isNotEmpty(startTime.get()) && EmptyUtil.isNotEmpty(ret)){
                log.info("【controller日志】响应 uuid : {} , url : {} ,return : {} , spend time : {} 毫秒",uuidRequest.get(),url , JSON.toJSONString(ret) , (System.currentTimeMillis() - startTime.get()));
            }
            // 使用完后清除，避免线程池污染value
            startTime.remove();
            uuidRequest.remove();
        } catch (Exception e) {
            log.error("weblog doAfterReturning Exception,cause = {}",e);
        }
    }

}
