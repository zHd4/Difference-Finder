package com.zhd4.difffinder.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface IFormatter {
    String formatDiff(List<Map<Object, Object>> diff) throws JsonProcessingException;
}
