package hexlet.code.differs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDiffer {
    List<Map<Object, Object>> generate(String path1, String path2) throws IOException;
}
