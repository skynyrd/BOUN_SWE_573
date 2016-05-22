package com.bounfoodcoop.repository;

import com.bounfoodcoop.core.documents.ProducerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProducerRepository extends MongoRepository<ProducerDocument, UUID> {
    ProducerDocument findByName(String name);

    List<ProducerDocument> findAllByOrderByCreatedAtDesc();
}
