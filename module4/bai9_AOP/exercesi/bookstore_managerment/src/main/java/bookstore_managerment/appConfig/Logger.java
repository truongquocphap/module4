package bookstore_managerment.appConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class Logger {
    @Pointcut("within(bookstore_managerment.controller.*)")
    public void addMethodPointcut(){
    }
    @Before("addMethodPointcut()")
    public void before(JoinPoint joinPoint){
        System.out.printf("Class Name:" + joinPoint.getSignature().getDeclaringTypeName()+
                "---method name: " +joinPoint.getSignature().getName() +
                "---Time: "+ LocalDate.now());
    }
}
