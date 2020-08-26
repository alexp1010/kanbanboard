package com.opal.service;

import com.opal.model.Task;
import com.opal.dataprovider.TaskProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

@Log4j2
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskProvider taskProvider;

    @Override
    public Task getTask(long id) {
        Task task = taskProvider.getTask(id);
        return task;
    }

    @Override
    public void testOperation() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        executor.execute(runnableTask);

        Future<String> future = executor.submit(callableTask);

        List<Future<String>> futures = new ArrayList<>();

        try {
            futures = executor.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (future.isDone()) System.out.println("the task is run");

        futures.stream().forEach(task -> System.out.println(task.isDone()));

        try {
            if(!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
