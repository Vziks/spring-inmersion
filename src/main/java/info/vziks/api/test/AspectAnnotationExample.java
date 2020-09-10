package info.vziks.api.test;

import info.vziks.api.aop.Bean;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Class AspectAnnotationExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class AspectAnnotationExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop-context.xml");
        Bean etc = new Bean();
        Bean mr = ctx.getBean("mrbean", Bean.class);

        mr.say(etc);
    }
}
