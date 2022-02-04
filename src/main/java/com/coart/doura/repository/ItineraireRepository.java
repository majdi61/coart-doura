package com.coart.doura.repository;


import com.coart.doura.domain.Itineraire;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ItineraireRepository extends MongoRepository<Itineraire, String> {

    @Query("?0")
    Page<Itineraire> filter(Document document, Pageable pageable);



}
