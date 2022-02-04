package com.coart.doura.service;


import com.coart.doura.domain.Task;
import com.coart.doura.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Page<Task> getTasksPage(Document document, Pageable pageable) {
        document = Optional.ofNullable(document).orElse(new Document());

        log.debug("doc: {}", document);
        document.putIfAbsent("removed", false);
        log.debug("doc: {}", document);
        return taskRepository.filter(document, pageable);
    }

    public Optional<Task> getTaskByIdAndRemovedFalse(String id) {
        return taskRepository.findTaskByIdAndRemovedFalse(id);
    }

    public void deleteTask(String id) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setRemoved(true);
            taskRepository.save(task);
        });
    }

}
