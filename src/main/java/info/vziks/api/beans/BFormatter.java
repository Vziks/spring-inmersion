package info.vziks.api.beans;

import org.springframework.stereotype.Component;

/**
 * Class BFormatter
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component("BFormatter")
public class BFormatter implements Formatter{

    public String format() {
        return "bformatter";
    }
}
