package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generateJsonDiff(String path1, String path2) throws IOException {
        StringBuilder result = new StringBuilder("{\n");

        Map<String, Object> map1 = Parser.parseFlatJsonFile(path1);
        Map<String, Object> map2 = Parser.parseFlatJsonFile(path2);

        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(map2.get(key).toString())
                        .append("\n");
            } else if (!map2.containsKey(key)) {
                result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(map1.get(key).toString())
                        .append("\n");
            } else if (map1.get(key).equals(map2.get(key))) {
                result.append("    ")
                        .append(key)
                        .append(": ")
                        .append(map2.get(key).toString())
                        .append("\n");
            } else {
                result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(map1.get(key).toString())
                        .append("\n");
                result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(map2.get(key).toString())
                        .append("\n");
            }
        }

        result.append("}");

        return result.toString();
    }

    public static String generateYamlDiff(String path1, String path2) {
        return null;
    }
}
