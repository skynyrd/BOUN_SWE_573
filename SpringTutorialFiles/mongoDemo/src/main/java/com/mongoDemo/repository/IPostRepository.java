package com.mongoDemo.repository;

import com.mongoDemo.domain.PostDocument;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface IPostRepository extends CrudRepository<PostDocument, BigInteger> {
    PostDocument findFirstByOrderByPostedOnDesc();

    List<PostDocument> findAllByOrderByPostedOnDesc();

    List<PostDocument> findAll();

    PostDocument findBySlug(String slug);

    @Query("select p from Post p where slug = :slug")
    List<PostDocument> findPostBySlugNative(@Param("slug") String slug);

}
