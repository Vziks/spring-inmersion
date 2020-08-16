package info.vziks.api.beans;

/**
 * Class MyBean
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class MyBean {
    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
