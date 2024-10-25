package app.difffinder;

import app.difffinder.formatters.IFormatter;
import app.difffinder.formatters.Json;
import app.difffinder.formatters.Plain;
import app.difffinder.formatters.Stylish;

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
