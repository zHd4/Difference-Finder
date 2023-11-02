package hexlet.code;

import hexlet.code.formatters.IFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.LinkedList;
import java.util.Arrays;

public class Differ {
    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }

    public static String generate(String path1, String path2, String format) throws IOException {
        Map<Object, Object> map1 = Parser.parse(readTextFile(path1), getFileFormat(path1));
        Map<Object, Object> map2 = Parser.parse(readTextFile(path2), getFileFormat(path2));

        IFormatter selectedFormatter = Formatter.chooseFormatter(format);
        return selectedFormatter.formatDiff(Tree.diff(map1, map2));
    }

    private static String readTextFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    private static String getFileFormat(String filepath) {
        return new LinkedList<>(Arrays.asList(filepath.split("\\."))).getLast();
    }
}
