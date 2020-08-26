package com.opal.dataprovider.h2;

import com.opal.dataconverter.TaskConverter;
import com.opal.dataprovider.TaskProvider;
import com.opal.model.Task;
import com.opal.dataaccesslayer.h2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskProviderImpl implements TaskProvider {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskConverter<com.opal.dataaccesslayer.h2.model.Task> taskConverter;

    @Override
    public Task getTask(long id) {
        com.opal.dataaccesslayer.h2.model.Task dataTask = taskRepository.findById(id).orElse(null);
        Task task = null;
        if(dataTask != null) {
            task = taskConverter.convert(dataTask);
        }
        return task;
    }
}
