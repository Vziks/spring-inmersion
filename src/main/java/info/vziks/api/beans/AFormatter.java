package info.vziks.api.beans;

import org.springframework.stereotype.Component;

/**
 * Class AFormatter
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component("AFormatter")
public class AFormatter implements Formatter{

    public String format() {
        return "aformatter";
    }
}
