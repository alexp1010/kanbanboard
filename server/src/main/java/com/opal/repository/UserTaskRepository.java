package com.opal.repository;


import com.opal.model.UserTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends CrudRepository<UserTask, Long> {
}
