package info.vziks.api.beans;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class ClassicMusic
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClassicMusic implements Music {

    @Override
    public String play() {
        return "ClassicMusic";
    }

    @Override
    @JsonProperty("type")
    public String toString() {
        return "ClassicMusic{}";
    }
}
