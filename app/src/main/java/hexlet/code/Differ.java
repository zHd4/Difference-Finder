package hexlet.code;

import hexlet.code.differs.IDiffer;
import hexlet.code.differs.JsonDiffer;
import hexlet.code.differs.YamlDiffer;
import hexlet.code.formatters.IFormatter;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.*;

public class Differ {
    private static final Map<String, IDiffer> availableDiffers = Map.of(
            "json", new JsonDiffer(),
            "yaml", new YamlDiffer(),
            "yml", new YamlDiffer());

    private static final Map<String, IFormatter> availableFormatters = Map.of(
            "stylish", new Stylish(),
            "plain", new Plain()
    );

    public static String generate(String path1, String path2, String format) throws IOException {
        String extension1 = new LinkedList<>(Arrays.asList(path1.split("\\."))).getLast();
        String extension2 = new LinkedList<>(Arrays.asList(path2.split("\\."))).getLast();

        if (!extension1.equals(extension2) ||
                !availableDiffers.containsKey(extension1) ||
                !availableDiffers.containsKey(extension2)) {
            List<String> supportedExtensions = availableDiffers.keySet()
                    .stream().map(name -> "." + name).toList();

            throw new IllegalArgumentException("Supported extensions: " +
                    String.join(", ", supportedExtensions));
        }

        if (!availableFormatters.containsKey(format)) {
            throw new IllegalArgumentException("Supported formats: " +
                    String.join(", ", availableFormatters.keySet()));
        }

        IDiffer selectedDiffer = availableDiffers.get(extension1);
        IFormatter selectedFormatter = availableFormatters.get(format);

        return selectedFormatter.formatDiff(selectedDiffer.generate(path1, path2));
    }
}
