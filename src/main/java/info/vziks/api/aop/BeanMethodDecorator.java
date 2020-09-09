package info.vziks.api.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Class BeanDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object retVal;

        if (invocation.getMethod().getName().equals("say")) {
            System.out.print("Mr. ");
            retVal = invocation.proceed();
            System.out.print("!");
            System.out.println();
        } else {
            retVal = invocation.proceed();
        }
        return retVal;
    }
}
