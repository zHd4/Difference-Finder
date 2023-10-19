package hexlet.code.differs;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FlatMapDiffer {
    public static String diff(Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder result = new StringBuilder("{\n");
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
}
