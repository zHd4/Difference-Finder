package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Parser {
    public static Map<Object, Object> parse(String content, String format) throws IOException {
        return switch (format) {
            case "json" -> parseFlatJson(content);
            case "yml", "yaml" -> parseFlatYaml(content);
            default -> throw new IllegalArgumentException("Supported extensions: json, yml, yaml");
        };
    }

    private static Map<Object, Object> parseFlatJson(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }

    private static Map<Object, Object> parseFlatYaml(String content) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, Map.class);
    }
}
