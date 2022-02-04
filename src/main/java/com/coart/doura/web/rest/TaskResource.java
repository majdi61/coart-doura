package com.coart.doura.web.rest;

import com.coart.doura.domain.Task;
import com.coart.doura.service.TaskService;
import com.turkraft.springfilter.boot.Filter;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskResource {

    private final TaskService taskService;


    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(taskService.saveTask(task)));
    }


    @GetMapping(path = "")
    public Page<Task> getTasksPage(@Filter(entityClass = Task.class) Document document, Pageable pageable) {
        return taskService.getTasksPage(document, pageable);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Task> getTaskByIdAndRemovedFalse(@PathVariable String id) {
        return ResponseUtil.wrapOrNotFound(taskService.getTaskByIdAndRemovedFalse(id));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        taskService.deleteTask(id);
    }

}
