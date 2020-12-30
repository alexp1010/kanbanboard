package com.opal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opal.model.UserTask;
import com.opal.service.UserTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserTaskServiceControllerTest {
    MockMvc mockMvc;
    ObjectMapper objectMapper;
    UserTaskService userTaskService;

    @BeforeEach
    void setup() {
        userTaskService = mock(UserTaskService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserTaskServiceController(userTaskService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Check usertasks/{user_id} endpoint")
    void getUserTask() {
        when(userTaskService.getTask(1)).thenReturn(new UserTask(1, "John"));
        try {
            mockMvc.perform(get("/usertasks/1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(objectMapper.writeValueAsString(new UserTask(1, "John"))))
                    .andExpect(status().isOk());
        } catch (JsonProcessingException e) {
        } catch (Exception e) {
        }
    }
}