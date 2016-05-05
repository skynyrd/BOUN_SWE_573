package com.bounfoodcoop.repository.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public @Data
class CommentDocument extends DocumentObject{
    private String title;
    private String content;
    private String user;
}
