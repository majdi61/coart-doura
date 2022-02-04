package com.coart.doura.repository;


import com.coart.doura.domain.Task;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("?0")
    Page<Task> filter(Document document, Pageable pageable);

    Optional<Task> findTaskByIdAndRemovedFalse(String id);

}
