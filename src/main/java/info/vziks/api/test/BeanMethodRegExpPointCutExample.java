package info.vziks.api.test;

import info.vziks.api.aop.BeanMethodNamePointCut;
import info.vziks.api.aop.BeanMethods;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * Class BeanMethodRegExpPointCutExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanMethodRegExpPointCutExample {

    public static void main(String[] args) {

        BeanMethods beanMethods = new BeanMethods();

        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        BeanMethodNamePointCut beanMethodNamePointCut = new BeanMethodNamePointCut();
        ProxyFactory proxyFactory = new ProxyFactory();

        Advisor advisor = new DefaultPointcutAdvisor(jdkRegexpMethodPointcut, beanMethodNamePointCut);

        jdkRegexpMethodPointcut.setPattern(".*run*.");

        proxyFactory.setTarget(beanMethods);
        proxyFactory.addAdvisor(advisor);

        BeanMethods proxy = (BeanMethods) proxyFactory.getProxy();

        proxy.say();
        proxy.jump();
        proxy.run();
        proxy.move();

    }
}
