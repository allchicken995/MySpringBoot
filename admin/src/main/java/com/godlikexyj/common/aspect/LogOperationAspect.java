package com.godlikexyj.common.aspect;

import com.godlikexyj.common.annotation.LogOperation;
import com.godlikexyj.common.user.UserDetail;
import com.godlikexyj.common.utils.HttpContextUtils;
import com.godlikexyj.common.utils.IpUtils;
import com.godlikexyj.common.utils.JsonUtils;
import com.godlikexyj.modules.log.entity.SysLogOperationEntity;
import com.godlikexyj.modules.log.enums.OperationStatusEnum;
import com.godlikexyj.modules.log.service.SysLogOperationService;
import com.godlikexyj.modules.security.user.SecurityUser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 操作日志，切面处理类
 *
 * @author glq gugameds066@gmail.com
 */
@Aspect
@Component
public class LogOperationAspect {
    @Resource
    private SysLogOperationService sysLogOperationService;

    @Pointcut("@annotation(com.godlikexyj.common.annotation.LogOperation)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        try {
            //执行方法
            Object result = point.proceed();
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatusEnum.SUCCESS.value());
            return result;
        } catch (Exception e) {
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatusEnum.FAIL.value());
            throw e;
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, Integer status) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), signature.getParameterTypes());
        LogOperation annotation = method.getAnnotation(LogOperation.class);
        SysLogOperationEntity log = new SysLogOperationEntity();
        if (annotation != null) {
            //注解上的描述
            log.setOperation(annotation.value());
        }
        //登录用户信息
        UserDetail user = SecurityUser.getUser();
        if (user != null) {
            log.setCreatorName(user.getUsername());
        }
        log.setStatus(status);
        log.setRequestTime((int) time);
        //请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setRequestUri(request.getRequestURI());
        log.setRequestMethod(request.getMethod());
        //请求参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JsonUtils.toJsonString(args[0]);
            log.setRequestParams(params);
        } catch (Exception e) {

        }
        //保存到DB
        sysLogOperationService.save(log);
    }
}