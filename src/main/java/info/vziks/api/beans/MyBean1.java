package info.vziks.api.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MyBeans1
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class MyBean1 implements IMyBean{
    private String name;

    public MyBean1(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private void doDestroy(){
        System.out.println("Destroy" + this.getClass());
    }

    private void doInit(){
        System.out.println("Init" + this.getClass());
    }
}

