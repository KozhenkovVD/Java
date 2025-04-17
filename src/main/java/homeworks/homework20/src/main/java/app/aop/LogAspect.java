package app.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("Pointcuts.AllController()")
    public Object loggingAroundCustomerController(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        if (signature.getDeclaringTypeName().indexOf("CustomerController") > 0) {
            if (signature.getName().equals("getAll")) {
                log.info("Получение всех покупателей. Выполнение метода " + joinPoint.getSignature().getName());
            } else if (signature.getName().equals("getCustomerById")) {
                log.info("Получение полуениниче покупатедля с id = " + joinPoint.getArgs()[0] + ". Выполнение метода " + joinPoint.getSignature().getName());
            }
        } else if (signature.getDeclaringTypeName().indexOf("OrderController") > 0) {
            if (signature.getName().equals("getAll")) {
                log.info("Получение всех заказов. Выполнение метода " + joinPoint.getSignature().getName());
            }
        }
         return joinPoint.proceed();

        }
    }