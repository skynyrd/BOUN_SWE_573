package com.bounfoodcoop.repository;

import com.bounfoodcoop.repository.documents.ProducerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProducerRepository extends MongoRepository<ProducerDocument, UUID> {
    ProducerDocument findByName(String name);
}
