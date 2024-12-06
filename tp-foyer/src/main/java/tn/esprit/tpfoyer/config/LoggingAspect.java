package tn.esprit.tpfoyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.tpfoyer.service.FoyerService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " :");
    }
    @After("execution(* tn.esprit.tpfoyer.service.FoyerService.*(..))")
    public void logMethodExit(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("Out method " + name);
    }
    @Before("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodEntry1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method 1 " + name + " :");
    }
    @Before("execution(public * tn.esprit.tpfoyer..*.*(..))")
    public void logMethodEntry2(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method 2 " + name + " :");
    }
    @Before("execution(* tn.esprit.tpfoyer.service.*.get*(..))")
    public void logMethodEntry3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method 3 " + name + " :");
    }
    @Before("execution(* tn.esprit.tpfoyer.service.BlocService.*(..))")
    public void logMethodEntry4(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method 4 " + name + " :");
    }
}
