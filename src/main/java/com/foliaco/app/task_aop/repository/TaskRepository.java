package com.foliaco.app.task_aop.repository;

import com.foliaco.app.task_aop.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
