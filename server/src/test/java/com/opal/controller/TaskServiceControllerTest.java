package com.opal.controller;

import com.opal.model.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceControllerTest extends AbstractControllerTest{
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getTask() throws Exception {
        String uri = "/gettask/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Task task = super.mapFromJson(content, Task.class);
        assertTrue(task != null);
    }
}