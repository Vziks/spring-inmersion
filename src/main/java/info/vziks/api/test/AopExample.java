package info.vziks.api.test;

import info.vziks.api.aop.Bean;
import info.vziks.api.aop.BeanDecorator;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Class AopExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class AopExample {

    public static void main(String[] args) {
        Bean mrbean = new Bean();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new BeanDecorator());
        pf.setTarget(mrbean);
        Bean proxy = (Bean) pf.getProxy();
        mrbean.say();
        System.out.println();
        proxy.say();
    }
}
