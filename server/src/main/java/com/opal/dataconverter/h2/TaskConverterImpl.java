package com.opal.dataconverter.h2;

import com.opal.dataaccesslayer.h2.model.Task;
import com.opal.dataconverter.TaskConverter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverterImpl implements TaskConverter<Task> {

    @Override
    public com.opal.model.Task convert(Task task) {
        com.opal.model.Task convertedTask = new com.opal.model.Task();
        convertedTask.setId(task.getId());
        convertedTask.setName(task.getName());
        return convertedTask;
    }
}
