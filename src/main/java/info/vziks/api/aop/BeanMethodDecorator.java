package info.vziks.api.aop;


import com.sun.tools.javac.util.List;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

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
        return clazz -> (List.of(Bean.class, Pickles.class).contains(clazz));
    }
}
