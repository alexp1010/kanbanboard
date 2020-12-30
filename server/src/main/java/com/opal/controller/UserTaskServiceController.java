package com.opal.controller;

import com.opal.service.UserTaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UserTaskServiceController {

    @Autowired
    private UserTaskService userTaskService;

    @GetMapping(value = "/usertasks/{userId}")
    public ResponseEntity<Object> getUserTask(@PathVariable("userId") long userId) {
        userTaskService.testOperation();
        return new ResponseEntity<>(userTaskService.getTask(userId), HttpStatus.OK);
    }
}
