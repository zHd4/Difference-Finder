package hexlet.code;

import hexlet.code.differs.IDiffer;
import hexlet.code.differs.JsonDiffer;
import hexlet.code.differs.YamlDiffer;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class Differ {
    private static final Map<String, IDiffer> availableDiffers = Map.of(
            "json", new JsonDiffer(),
            "yaml", new YamlDiffer(),
            "yml", new YamlDiffer());

    public static String generate(String path1, String path2) throws IOException {
        String extension1 = new LinkedList<>(Arrays.asList(path1.split("\\."))).getLast();
        String extension2 = new LinkedList<>(Arrays.asList(path2.split("\\."))).getLast();

        if (!extension1.equals(extension2) ||
                !availableDiffers.containsKey(extension1) ||
                !availableDiffers.containsKey(extension2)) {
            throw new IllegalArgumentException("Supported extensions: .json, .yaml, .yml");
        }

        return new Stylish().formatDiff(availableDiffers.get(extension1).generate(path1, path2));
    }
}
