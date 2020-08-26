package com.opal.service;

import com.opal.dataprovider.TaskProvider;
import com.opal.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskProvider taskProvider;

    @Test
    void getTask() {
        Task task = new Task();
        task.setId(1);
        task.setName("task name 1");

        Mockito.when(taskProvider.getTask(1)).thenReturn(task);

        Task taskToCheck = taskService.getTask(1);
        boolean taskExists = taskToCheck != null;
        assertTrue(taskExists);
    }
}