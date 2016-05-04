package com.mongoDemo.repository;

import com.mongoDemo.domain.AuthorDocument;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface IAuthorRepository extends CrudRepository<AuthorDocument, BigInteger> {
}
