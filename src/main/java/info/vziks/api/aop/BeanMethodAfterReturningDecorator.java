package info.vziks.api.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodAfterReturningDecorator implements AfterReturningAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

//        System.out.println(method.getName());

//        if (method.getName().equals("say")) {
            System.out.println("After Returning Method");
//        }
    }
}
