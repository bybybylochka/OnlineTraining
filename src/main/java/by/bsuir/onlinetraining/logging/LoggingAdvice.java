package by.bsuir.onlinetraining.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.beans.Introspector;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LoggingAdvice {
    @Pointcut("within(by.bsuir.onlinetraining.service.impl..*)")
    public void servicePointcut() { }

    @Before("servicePointcut()")
    public void logMethodInvocation(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("Method {}.{} called with args {}", getClassName(joinPoint), getMethodName(joinPoint), Arrays.toString(args));
    }

    @AfterReturning(pointcut = "servicePointcut()", returning = "result")
    public void logMethodExecutionResult(JoinPoint joinPoint, Object result) {
        log.info("Method {}.{} returned {}", getClassName(joinPoint), getMethodName(joinPoint), result);
    }

    @AfterThrowing(pointcut = "servicePointcut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        log.error("Method {}.{} threw an exception {} ", getClassName(joinPoint), getMethodName(joinPoint), exception.getMessage());
    }

    private String getClassName(JoinPoint joinPoint) {
        return Introspector.decapitalize(
                joinPoint.getSignature()
                        .getDeclaringType()
                        .getSimpleName()
        );
    }

    private String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }
}