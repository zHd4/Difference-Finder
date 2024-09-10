package com.zhd4.difffinder.formatters;

import java.util.List;
import java.util.Map;

public final class Stylish implements IFormatter {

    @Override
    public String formatDiff(List<Map<Object, Object>> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<Object, Object> changeMap : diff) {
            String type = String.valueOf(changeMap.get("diff"));
            String key = String.valueOf(changeMap.get("key"));

            String value = valueToString(changeMap.getOrDefault("value", changeMap.get("value1")));
            String value2 = valueToString(changeMap.getOrDefault("value2", null));

            switch (type) {
                case "added" -> result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value)
                        .append("\n");
                case "deleted" -> result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value)
                        .append("\n");
                case "changed" -> {
                    result.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(value)
                            .append("\n");
                    result.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(value2)
                            .append("\n");
                }
                case "unchanged" -> result.append("    ")
                        .append(key)
                        .append(": ")
                        .append(value)
                        .append("\n");
                default -> {
                }
            }
        }

        result.append("}");
        return result.toString();
    }

    private String valueToString(Object value) {
        return value != null ? value.toString() : "null";
    }
}
