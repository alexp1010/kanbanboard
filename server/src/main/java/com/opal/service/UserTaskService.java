package com.opal.service;

import com.opal.model.UserTask;
import org.springframework.stereotype.Service;

@Service
public interface UserTaskService {
    UserTask getTask(long id);
    void testOperation();
}
