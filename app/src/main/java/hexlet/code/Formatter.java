package hexlet.code;

import hexlet.code.formatters.IFormatter;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    private static final Map<String, IFormatter> availableFormatters = Map.of(
            "stylish", new Stylish(),
            "plain", new Plain()
    );

    public static IFormatter chooseFormatter(String format) {
        if (!availableFormatters.containsKey(format)) {
            throw new IllegalArgumentException("Supported formats: " +
                    String.join(", ", availableFormatters.keySet()));
        }

        return availableFormatters.get(format);
    }
}
