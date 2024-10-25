package app.difffinder.formatters;

import java.util.List;
import java.util.Map;

public final class Plain implements IFormatter {
    @Override
    public String formatDiff(List<Map<Object, Object>> diff) {
        StringBuilder result = new StringBuilder();

        for (Map<Object, Object> changeMap : diff) {
            String type = String.valueOf(changeMap.get("diff"));
            String key = String.valueOf(changeMap.get("key"));

            String value = valueToString(changeMap.getOrDefault("value", changeMap.get("value1")));
            String value2 = valueToString(changeMap.getOrDefault("value2", null));

            switch (type) {
                case "added" -> result.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(value)
                        .append("\n");
                case "deleted" -> result.append("Property '")
                        .append(key)
                        .append("' was removed\n");
                case "changed" -> result.append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(value)
                        .append(" to ")
                        .append(value2)
                        .append("\n");
                default -> {
                }
            }
        }

        return result.toString().trim();
    }

    private String valueToString(Object value) {
        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }
}
