package info.vziks.api.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import info.vziks.api.model.Issue;

import java.io.IOException;
import java.util.List;

/**
 * Class CustomListSerializer
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class CustomListSerializer extends StdSerializer<List<Issue>> {

    protected CustomListSerializer(Class<List<Issue>> t) {
        super(t);
    }

    public void serialize(List<Issue> issues, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        generator.writeStartArray();

        for (Issue issue : issues) {
            generator.writeStartObject();
            generator.writeNumberField("id", issue.getId());
            generator.writeStringField("name", issue.getIssue());

            generator.writeEndObject();
        }
        generator.writeEndArray();
    }


}
