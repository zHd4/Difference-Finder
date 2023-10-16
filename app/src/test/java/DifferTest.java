import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.Differ;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    void testGenerate() throws IOException {
        String filePath1 = "./src/test/resources/file1.json";
        String filePath2 = "./src/test/resources/file2.json";

        String actual = Differ.generate(filePath1, filePath2);
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        assertThat(actual).isEqualTo(expected);
    }
}
