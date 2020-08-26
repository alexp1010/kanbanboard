package com.opal.service;

import com.opal.model.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    Task getTask(long id);
    void testOperation();
}
