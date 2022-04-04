package com.example.template.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggableAspect {

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
    }

    /**
     * Будет выполнено до начала метода
     */
    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName()).append("!");
        Arrays.stream(joinPoint.getArgs()).forEach(arg ->
                message.append("args: ").append(arg).append("!")
        );

        log.info(message.toString());
    }

    /**
     * Будет выполнено после возврата методом значения
     */
    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void logMethodCall(JoinPoint joinPoint, Object returnValue) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName()).append("!");
        message.append("return value: ").append(returnValue);

        log.info(message.toString());
    }

    /**
     * Будет выполнено в процессе выполнения метода. Замер времени выполнения
     */
    @SneakyThrows
    @Around("executeLogging()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();

        Object returnValue = joinPoint.proceed();
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName()).append("!");

        long finish = System.currentTimeMillis();

        message.append("time: ").append(finish - start).append(" milliseconds");
        log.info(message.toString());
        return returnValue;
    }
}
