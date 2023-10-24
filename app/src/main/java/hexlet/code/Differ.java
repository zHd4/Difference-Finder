package hexlet.code;

import hexlet.code.differs.IDiffer;
import hexlet.code.differs.JsonDiffer;
import hexlet.code.differs.YamlDiffer;
import hexlet.code.formatters.IFormatter;

import java.io.IOException;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Differ {
    private static final Map<String, IDiffer> AVAILABLE_DIFFERS = Map.of(
            "json", new JsonDiffer(),
            "yaml", new YamlDiffer(),
            "yml", new YamlDiffer());

    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }

    public static String generate(String path1, String path2, String format) throws IOException {
        String extension1 = new LinkedList<>(Arrays.asList(path1.split("\\."))).getLast();
        String extension2 = new LinkedList<>(Arrays.asList(path2.split("\\."))).getLast();

        if (!extension1.equals(extension2)
                || !AVAILABLE_DIFFERS.containsKey(extension1)
                || !AVAILABLE_DIFFERS.containsKey(extension2)) {
            List<String> supportedExtensions = AVAILABLE_DIFFERS.keySet()
                    .stream().map(name -> "." + name).toList();

            throw new IllegalArgumentException("Supported extensions: "
                    + String.join(", ", supportedExtensions));
        }

        IDiffer selectedDiffer = AVAILABLE_DIFFERS.get(extension1);
        IFormatter selectedFormatter = Formatter.chooseFormatter(format);

        return selectedFormatter.formatDiff(selectedDiffer.generate(path1, path2));
    }
}
