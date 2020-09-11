package info.vziks.api.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodDecorator extends StaticMethodMatcherPointcut implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object retVal;

        System.out.print("Mr. ");
        retVal = invocation.proceed();
        System.out.print("!");
        System.out.println();

        return retVal;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        return ("say".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
//        return clazz -> (clazz == Bean.class);
        return clazz -> (new ArrayList<>(Arrays.asList(Bean.class, Pickles.class)).contains(clazz));
    }
}
