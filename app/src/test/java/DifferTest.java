import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private static final String expectedDiff = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

    @Test
    void testJsonDiff() throws IOException {
        String filePath1 = "./src/test/resources/file1.json";
        String filePath2 = "./src/test/resources/file2.json";

        String actual = Differ.generate(filePath1, filePath2);

        assertEquals(expectedDiff, actual);
    }

    @Test
    void testYamlDiff() throws IOException {
        String filePath1 = "./src/test/resources/file1.yml";
        String filePath2 = "./src/test/resources/file2.yml";

        String actual = Differ.generate(filePath1, filePath2);

        assertEquals(expectedDiff, actual);
    }
}
