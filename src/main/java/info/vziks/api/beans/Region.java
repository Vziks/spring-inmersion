package info.vziks.api.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Class Region
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component
public class Region {
    @Lazy
    @Autowired
    public City city;

    public Region() {
        System.out.println("Init city instance");
    }

    public City getCityInstance() {
        return city;
    }


    @Override
    public String toString() {
        return "Region{" +
                "city=" + city +
                '}';
    }
}
