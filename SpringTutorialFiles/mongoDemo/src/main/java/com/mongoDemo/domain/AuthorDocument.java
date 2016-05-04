package com.mongoDemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document
public class AuthorDocument {

    @Id
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String eMail;

    @DBRef
    private List<PostDocument> posts;

    public AuthorDocument() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<PostDocument> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDocument> posts) {
        this.posts = posts;
    }
}
