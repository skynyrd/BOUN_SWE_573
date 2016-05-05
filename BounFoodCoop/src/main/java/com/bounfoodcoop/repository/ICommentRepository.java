package com.bounfoodcoop.repository;

import com.bounfoodcoop.repository.documents.CommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICommentRepository extends MongoRepository<CommentDocument, UUID> {
}
