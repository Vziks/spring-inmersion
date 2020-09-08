package info.vziks.api.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Mr. ");
        Object retVal = invocation.proceed();
        System.out.print("!");
        System.out.println();
        return retVal;
    }
}
