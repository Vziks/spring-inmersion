package info.vziks.api.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Class CFormatter
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component
@Primary
public class CFormatter implements Formatter {

    public String format() {
        return "cformatter";
    }
}
