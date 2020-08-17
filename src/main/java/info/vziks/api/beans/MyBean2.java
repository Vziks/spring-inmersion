package info.vziks.api.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MyBean2
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyBean2 implements IMyBean{
    private String name;

    private MyBean2(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }


    public static MyBean2 getInstance(){
        System.out.println("static init class MyBean2");
        return new MyBean2("static init class MyBean2");
    }

    public void setName(String name) {
        this.name = name;
    }

}
