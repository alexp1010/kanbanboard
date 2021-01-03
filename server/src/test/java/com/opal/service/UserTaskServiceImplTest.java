package com.opal.service;

import com.opal.model.UserTask;
import com.opal.repository.UserTaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTaskServiceImplTest {

    @Mock
    private UserTaskRepository userTaskRepository;
    @InjectMocks
    private UserTaskService userTaskService = new UserTaskServiceImpl();

//    @BeforeEach
//    void setup() {
//        userTaskRepository = mock(UserTaskRepository.class);
//        userTaskService = new UserTaskServiceImpl(userTaskRepository);
//    }

    @Test
    @DisplayName("Check getting a task")
    void getTask() {
        when(userTaskRepository.findById(1L)).thenReturn(Optional.of(new UserTask(1, "John")));
        UserTask userTask = userTaskService.getTask(1L);
        assertThat(userTask).isNotNull();
        assertThat(userTask.getId()).isEqualTo(1L);
        assertThat(userTask.getName()).isEqualTo("John");
    }
}