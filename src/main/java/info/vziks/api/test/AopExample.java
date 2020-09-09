package info.vziks.api.test;

import info.vziks.api.aop.*;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Class AopExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class AopExample {

    public static void main(String[] args) {

//        System.out.println("/***/");
//
//        Bean mrbean = new Bean();
//
        ProxyFactory pf = new ProxyFactory();
//        pf.addAdvice(new BeanMethodDecorator());
//        pf.setTarget(mrbean);
//        Bean proxy = (Bean) pf.getProxy();
//        mrbean.say();
//        mrbean.add();
//        System.out.println();
//        proxy.say();
//        proxy.add();
//
//        System.out.println();
//        System.out.println("/***/");
//
//        pf = new ProxyFactory();
//        pf.addAdvice(new BeanMethodBeforeDecorator());
//        pf.setTarget(mrbean);
//        proxy = (Bean) pf.getProxy();
//        mrbean.say();
//        mrbean.add();
//        System.out.println();
//        proxy.say();
//        proxy.add();
//
//        System.out.println();
//        System.out.println("/***/");
//
//        pf = new ProxyFactory();
//        pf.addAdvice(new BeanMethodAfterReturningDecorator());
//        pf.setTarget(mrbean);
//        proxy = (Bean) pf.getProxy();
//        mrbean.say();
//        mrbean.add();
//        System.out.println();
//        proxy.say();
//        proxy.add();


        BeanError mrbeanerror = new BeanError();

        pf = new ProxyFactory();
        pf.addAdvice(new BeanMethodThrowsAdviceDecorator());
        pf.setTarget(mrbeanerror);
        BeanError proxyError = (BeanError) pf.getProxy();
        try {
            mrbeanerror.error();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        System.out.println();
        try {
            proxyError.error();
        } catch (Exception e) {
//            e.printStackTrace();
        }


    }
}
