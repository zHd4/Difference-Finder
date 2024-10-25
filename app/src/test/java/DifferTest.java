import static org.junit.jupiter.api.Assertions.assertEquals;

import app.difffinder.Differ;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private static String stylishExpected;
    private static String plainExpected;
    private static String jsonExpected;

    @BeforeAll
    public static void loadFixtures() throws IOException {
        stylishExpected = readFixture("stylish_expected.txt");
        plainExpected = readFixture("plain_expected.txt");
        jsonExpected = readFixture("json_expected.json");
    }

    private static String readFixture(String filename) throws IOException {
        return Files.readString(Path.of(generateFixturePath(filename)));
    }

    private static String generateFixturePath(String filename) {
        return Path.of("src/test/resources/fixtures/" + filename).toString();
    }

    @Test
    void testJsonStylishDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.json"),
                generateFixturePath("file2.json"));
        assertEquals(stylishExpected, actual);
    }

    @Test
    void testYamlStylishDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.yml"),
                generateFixturePath("file2.yml"));
        assertEquals(stylishExpected, actual);
    }

    @Test
    void testJsonPlainDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.json"),
                generateFixturePath("file2.json"),
                "plain");
        assertEquals(plainExpected, actual);
    }

    @Test
    void testYamlPlainDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.yml"),
                generateFixturePath("file2.yml"),
                "plain");
        assertEquals(plainExpected, actual);
    }

    @Test
    void testJsonFormatDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.json"),
                generateFixturePath("file2.json"),
                "json");
        assertEquals(jsonExpected, actual);
    }

    @Test
    void testYamlJsonFormatDiff() throws IOException {
        String actual = Differ.generate(generateFixturePath("file1.yml"),
                generateFixturePath("file2.yml"),
                "json");
        assertEquals(jsonExpected, actual);
    }
}
