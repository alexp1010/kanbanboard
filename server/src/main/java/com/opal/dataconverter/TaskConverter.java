package com.opal.dataconverter;

import com.opal.model.Task;
import org.springframework.stereotype.Component;

@Component
public interface TaskConverter<T> extends DataConverter {
    public Task convert(T task);
}
