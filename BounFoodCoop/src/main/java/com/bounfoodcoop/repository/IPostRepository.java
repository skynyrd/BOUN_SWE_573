package com.bounfoodcoop.repository;

import com.bounfoodcoop.repository.documents.PostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPostRepository extends MongoRepository<PostDocument, UUID> {
}
