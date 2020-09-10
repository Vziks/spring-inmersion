package info.vziks.api.aop;

import org.springframework.stereotype.Component;

/**
 * Class Bean
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component("mrbean")
public class Bean {

    public void say(){
        System.out.print("Bean");
    }


    public void say(Bean bean){
        System.out.print("Bean args");
    }

    public void add(){
        System.out.print("add Bean");
    }
}
