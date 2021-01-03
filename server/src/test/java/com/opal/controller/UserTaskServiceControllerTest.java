package com.opal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opal.model.UserTask;
import com.opal.service.UserTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(UserTaskServiceController.class)
class UserTaskServiceControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserTaskService userTaskService;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        //userTaskService = mock(UserTaskService.class);
        //mockMvc = MockMvcBuilders.standaloneSetup(new UserTaskServiceController(userTaskService)).build();
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