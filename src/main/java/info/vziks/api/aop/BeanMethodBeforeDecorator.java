package info.vziks.api.aop;


import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodBeforeDecorator extends DynamicMethodMatcherPointcut implements MethodBeforeAdvice  {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
//        if (method.getName().equals("say")) {
            System.out.println("Before Method");
//        }
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
