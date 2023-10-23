package hexlet.code;

import hexlet.code.formatters.IFormatter;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    private static final Map<String, IFormatter> AVAILABLE_FORMATTERS = Map.of(
            "stylish", new Stylish(),
            "plain", new Plain(),
            "json", new Json()
    );

    public static IFormatter chooseFormatter(String format) {
        if (!AVAILABLE_FORMATTERS.containsKey(format)) {
            throw new IllegalArgumentException("Supported formats: "
                    + String.join(", ", AVAILABLE_FORMATTERS.keySet()));
        }

        return AVAILABLE_FORMATTERS.get(format);
    }
}
