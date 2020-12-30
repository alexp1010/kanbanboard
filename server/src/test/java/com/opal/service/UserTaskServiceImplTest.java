package com.opal.service;

import com.opal.model.UserTask;
import com.opal.repository.UserTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTaskServiceImplTest {

    private UserTaskRepository userTaskRepository;
    private UserTaskService userTaskService;

    @BeforeEach
    void setup() {
        userTaskRepository = mock(UserTaskRepository.class);
        userTaskService = new UserTaskServiceImpl(userTaskRepository);
    }

    @Test
    @DisplayName("Check getTask()")
    void getTask() {
        when(userTaskRepository.findById(1L)).thenReturn(Optional.of(new UserTask(1, "John")));
        UserTask userTask = userTaskService.getTask(1L);
        assertThat(userTask).isNotNull();
        assertThat(userTask.getId()).isEqualTo(1L);
        assertThat(userTask.getName()).isEqualTo("John");
    }
}