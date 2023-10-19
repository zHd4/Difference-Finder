package hexlet.code.differs;

import hexlet.code.Parser;

import java.io.IOException;
import java.util.Map;

public class JsonDiffer implements IDiffer{
    @Override
    public String generate(String path1, String path2) throws IOException {
        Map<String, Object> map1 = Parser.parseFlatJsonFile(path1);
        Map<String, Object> map2 = Parser.parseFlatJsonFile(path2);

        return FlatMapDiffer.diff(map1, map2);
    }
}
