package info.vziks.api.beans;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PopMusic
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PopMusic implements Music {
    @Override
    public String play() {
        return "PopMusic";
    }

    @Override
    @JsonProperty("type")
    public String toString() {
        return "PopMusic{}";
    }
}
