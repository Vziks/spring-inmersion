package info.vziks.api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Class AnnotatedAdvice
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component
@Aspect
public class AnnotatedAdvice {

    @Pointcut("execution(* info.vziks.api.aop.*.say(info.vziks.api.aop.Bean)) && args(value))")
    public void sayExe(Bean value){
    }

    @Before("sayExe(value)")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Bean value) {
        System.out.println("before");
        System.out.println(joinPoint.getSignature().getName());
    }

    @Around("sayExe(value)")
    public Object simpleAroundAdvice(ProceedingJoinPoint point, Bean value) throws Throwable {
        System.out.println("Around before");
        Object obj = point.proceed();
        System.out.println("Around after");
        return obj;
    }

}
