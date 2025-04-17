package app.aop;
import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {
    @Pointcut("execution(* app.controller.*.*(..))")
    public void AllController() {
    }

}
