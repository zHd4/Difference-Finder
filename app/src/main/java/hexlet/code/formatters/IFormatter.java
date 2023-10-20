package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public interface IFormatter {
    String formatDiff(List<Map<Object, Object>> diff);
}
