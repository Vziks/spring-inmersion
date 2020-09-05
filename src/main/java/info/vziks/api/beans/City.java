package info.vziks.api.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Class City
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Lazy
@Component
public class City {

    public City() {
        System.out.println("Init city instance");
    }
}
