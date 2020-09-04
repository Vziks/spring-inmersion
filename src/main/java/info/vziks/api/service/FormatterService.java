package info.vziks.api.service;

import info.vziks.api.beans.Formatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Class FormatterService
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Component
public class FormatterService {

    private final Formatter aFormatter;

    private final Formatter bFormatter;

    private final Formatter cFormatter;

    public FormatterService(@Qualifier("AFormatter") Formatter aFormatter, @Qualifier("BFormatter") Formatter bFormatter, Formatter cFormatter) {
        this.aFormatter = aFormatter;
        this.bFormatter = bFormatter;
        this.cFormatter = cFormatter;
    }
}
