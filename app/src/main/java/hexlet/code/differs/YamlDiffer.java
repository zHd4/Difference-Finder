package hexlet.code.differs;

import hexlet.code.Parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YamlDiffer implements IDiffer{
    @Override
    public List<Map<Object, Object>> generate(String path1, String path2) throws IOException {
        Map<Object, Object> map1 = Parser.parseFlatYamlFile(path1);
        Map<Object, Object> map2 = Parser.parseFlatYamlFile(path2);

        return MapDiffer.diff(map1, map2);
    }
}
