package info.vziks.api.service;

import info.vziks.api.beans.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    @Qualifier("AFormatter")
    private Formatter aformatter;

    @Autowired
    @Qualifier("BFormatter")
    private Formatter bformatter;


    @Autowired
    private Formatter cFormatter;


}
