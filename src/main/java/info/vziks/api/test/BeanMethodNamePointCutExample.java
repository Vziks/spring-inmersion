package info.vziks.api.test;

import info.vziks.api.aop.BeanMethodNamePointCut;
import info.vziks.api.aop.BeanMethods;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Class BeanMethodNamePointCutExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodNamePointCutExample {


    public static void main(String[] args) {

        BeanMethods beanMethods = new BeanMethods();

        BeanMethodNamePointCut beanMethodNamePointCut = new BeanMethodNamePointCut();
        ProxyFactory proxyFactory = new ProxyFactory();

        Advisor advisor = new DefaultPointcutAdvisor(beanMethodNamePointCut, beanMethodNamePointCut);

        beanMethodNamePointCut.addMethodName("run");
        beanMethodNamePointCut.addMethodName("jump");

        proxyFactory.setTarget(beanMethods);
        proxyFactory.addAdvisor(advisor);

        BeanMethods proxy = (BeanMethods) proxyFactory.getProxy();

        proxy.say();
        proxy.jump();
        proxy.run();
        proxy.move();

    }
}
