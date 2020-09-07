package info.vziks.api.test;

import info.vziks.api.beans.NamedSinger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Class Beans
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Beans {

    public static void main(String[] args) {


//        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:myAppContext.xml");
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:myAppContext.xml");
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("classpath:myAppContext.xml");
        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext("classpath:myAppContext.xml");
//        applicationContext.load("classpath:myAppContext.xml");
//        applicationContext.refresh();

        System.out.println(applicationContext.getBean("parent"));
        System.out.println(applicationContext.getBean("child"));


        System.out.println(applicationContext1.getBean("parent"));
        System.out.println(applicationContext1.getBean("child"));


        System.out.println(applicationContext2.getBean("parent"));
        System.out.println(applicationContext2.getBean("child"));


        NamedSinger namedSinger = (NamedSinger) applicationContext.getBean("namedSinger");

        namedSinger.sing();

        applicationContext.registerShutdownHook();

    }
}
