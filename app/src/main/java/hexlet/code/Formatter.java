package hexlet.code;

import hexlet.code.formatters.IFormatter;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

public class Formatter {
    public static IFormatter chooseFormatter(String format) {
        return switch (format) {
            case "stylish" -> new Stylish();
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> throw new IllegalArgumentException("Supported formats: stylish, plain, json");
        };
    }
}
