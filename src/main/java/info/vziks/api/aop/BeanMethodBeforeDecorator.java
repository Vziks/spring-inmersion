package info.vziks.api.aop;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodBeforeDecorator implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
//        if (method.getName().equals("say")) {
            System.out.println("Before Method");
//        }
    }

}
