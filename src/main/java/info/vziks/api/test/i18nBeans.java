package info.vziks.api.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Class i18nBeans
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class i18nBeans {


    public static void main(String[] args) {

        ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:myAppContext.xml");

        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru", "RU");


        System.out.println(cxt.getMessage("message", null, english));
        System.out.println(cxt.getMessage("message", null, russian));
        System.out.println(cxt.getMessage("messageParams", new Object[] {"code"}, english));
        System.out.println(cxt.getMessage("messageParams", new Object[] {"code"}, russian));

    }
}
