package dgroomes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.List;

/**
 * Serialize an object to a YAML string using the Jackson serialization libraries.
 * <p>
 * This is a toy class. It is used used as the object-under-test in a JMeter load test.
 */
public class Serializer {

    public enum Fruit {
        APPLE, BANANA, ORANGE
    }

    private final ObjectMapper objectMapper;

    public Serializer() {
        this(new ObjectMapper(new YAMLFactory()));
    }

    public Serializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Serialize a list of Fruit objects into a YAML string
     *
     * @param fruits list of fruits to serialize
     * @return the list of fruits serialized as a YAML-formatted string
     */
    public String serialize(List<Fruit> fruits) {
        try {
            return objectMapper.writeValueAsString(fruits);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize the list of Fruit objects", e);
        }
    }

    public static void main(String[] args) {
        var yamlSerializer = new Serializer();
        var fruit = List.of(Fruit.BANANA, Fruit.BANANA, Fruit.APPLE);
        var yaml = yamlSerializer.serialize(fruit);
        System.out.printf("Serialized a list of fruit objects in the following YAML document:\n%s\n", yaml);
    }
}
