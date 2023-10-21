package hexlet.code.differs;

import java.util.*;

public class MapDiffer {
    public static List<Map<Object, Object>> diff(Map<Object, Object> map1, Map<Object, Object> map2) {
        List<Map<Object, Object>> result = new ArrayList<>();
        Set<Object> keys = new TreeSet<>(map1.keySet());

        keys.addAll(map2.keySet());

        for (Object key : keys) {
            Map<Object, Object> difference = new HashMap<>();

            difference.put("key", key);

            if (!map1.containsKey(key)) {
                difference.put("diff", "added");
                difference.put("value", map2.get(key));
            } else if (!map2.containsKey(key)) {
                difference.put("diff", "deleted");
                difference.put("value", map1.get(key));
            } else if (isEqual(map1.get(key), map2.get(key))) {
                difference.put("diff", "unchanged");
                difference.put("value", map2.get(key));
            } else {
                difference.put("diff", "changed");
                difference.put("value1", map1.get(key));
                difference.put("value2", map2.get(key));
            }

            result.add(difference);
        }

        return result;
    }

    private static Boolean isEqual(Object value1, Object value2) {
        return value1 == null || value2 == null ? value1 == value2 : value1.equals(value2);
    }
}
