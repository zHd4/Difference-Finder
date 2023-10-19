package hexlet.code.differs;

import java.io.IOException;

public interface IDiffer {
    String generate(String path1, String path2) throws IOException;
}
