package info.vziks.api.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Class BeanMethodThrowsAdviceDecorator
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodThrowsAdviceDecorator implements ThrowsAdvice {
    public void afterThrowing(Exception e) throws Throwable {
        System.out.println("BeanMethodThrowsAdviceDecorator : Throw exception!");
    }
}
