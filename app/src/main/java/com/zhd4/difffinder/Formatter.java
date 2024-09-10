package com.zhd4.difffinder;

import com.zhd4.difffinder.formatters.IFormatter;
import com.zhd4.difffinder.formatters.Json;
import com.zhd4.difffinder.formatters.Plain;
import com.zhd4.difffinder.formatters.Stylish;

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
