package info.vziks.api.aop;

/**
 * Class BeanError
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class BeanError {

    public void error() throws Exception {
        throw new Exception("BeanError");
    }
}
