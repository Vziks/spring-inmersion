package info.vziks.api.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class MyBean
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyBean implements IMyBean{
    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Destroy method is called with singleton scope bean but not with prototype because
     * Spring does not manage the complete lifecycle of a prototype bean:
     * the container instantiates, configures, decorates and otherwise assembles
     * a prototype object, hands it to the client and then has no further
     * knowledge of that prototype instance. For releasing resources try to
     * implement a custom bean post processor.
     */
    private void doDestroy(){
        System.out.println("Destroy" + this.getClass());
    }

    private void doInit(){
        System.out.println("Init" + this.getClass());
    }
}
