package com.bounfoodcoop.repository;

import documents.ProducerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProducerRepository extends MongoRepository<ProducerDocument, UUID> {
    ProducerDocument findByName(String name);
}
