package bookstore_managerment.app_config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class Logger {
    int count =0;
    @Pointcut("within(bookstore_managerment.controller.*)")
    public void addMethodPointcut(){
    }
    @After("addMethodPointcut()")
    public void before(JoinPoint joinPoint){
        System.out.printf("Class Name:" + joinPoint.getSignature().getDeclaringTypeName()+
                "---method name: " +joinPoint.getSignature().getName() +
                "---Time: "+ LocalDate.now()+
                "Count:" + ++count);
    }

    @Pointcut("execution(* bookstore_managerment.controller.BookController.giveBook(..))")
    public void wiredGiveMethod(){
    }
    @After("wiredGiveMethod()")
    public void give(JoinPoint joinPoint){
        System.out.printf("---method name: " +joinPoint.getSignature().getName() +
                "---Time: "+ LocalDate.now());
    }
    @Pointcut("execution(* bookstore_managerment.controller.BookController.rent(..))")
    public void wiredRentMethod(){
    }
    @After("wiredRentMethod()")
    public void rent(JoinPoint joinPoint){
        System.out.printf("---method name: " +joinPoint.getSignature().getName() +
                "---Time: "+ LocalDate.now());
    }

}
