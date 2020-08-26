package com.opal.dataprovider;

import com.opal.model.Task;
import org.springframework.stereotype.Component;

@Component
public interface TaskProvider {
    Task getTask(long id);
}
