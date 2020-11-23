package com.crud.tasks_api.repository;

import com.crud.tasks_api.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    Optional<Task> findById(Long id);

    @Override
    Task save(Task task);

    @Override
    void deleteById(Long taskId);
}
