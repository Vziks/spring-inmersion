package info.vziks.api.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Class BeanMethodNamePointCut
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodNamePointCut extends NameMatchMethodPointcut implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object retVal;

        System.out.println("/*invoke*/");
        System.out.println("Mr. ");
        retVal = invocation.proceed();
        System.out.println("!");
        System.out.println("/*invoke*/");

        return retVal;
    }
}
