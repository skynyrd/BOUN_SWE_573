package com.bounfoodcoop.repository.documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public @Data class PostDocument extends DocumentObject {
    private String title;
    private String content;
    @DBRef
    private List<CommentDocument> commentList;
    private int category;
}
