package com.opal.dataaccesslayer.h2.repository;

import com.opal.dataaccesslayer.h2.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
