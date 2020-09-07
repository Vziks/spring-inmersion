package info.vziks.api.beans;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Class NamedSinger
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class NamedSinger implements BeanNameAware {
    private String name;

    /**
     * @Implements {@link BeanNameAware#setBeanName(String)}
     **/
    public void setBeanName(String s) {
        this.name = s;
    }

    public void sing() {
        System.out.println("Singer " + name);
    }
}
