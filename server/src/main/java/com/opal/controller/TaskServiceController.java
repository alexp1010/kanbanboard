package com.opal.controller;

import com.opal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskServiceController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/gettask/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getTask(@PathVariable("id") long id) {
        taskService.testOperation();
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }
}
