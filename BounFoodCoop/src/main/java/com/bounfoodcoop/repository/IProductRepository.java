package com.bounfoodcoop.repository;

import documents.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository extends MongoRepository<ProductDocument, UUID> {
    ProductDocument findById(UUID uuid);

    List<ProductDocument> findAllByOrderByCreatedAtDesc();

    ProductDocument findByName(String name);
}
