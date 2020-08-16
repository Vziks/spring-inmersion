package info.vziks.api.beans;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class RockMusic
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RockMusic implements Music {
    @Override
    public String play() {
        return "RockMusic";
    }

    @Override
    @JsonProperty("type")
    public String toString() {
        return "RockMusic{}";
    }
}
