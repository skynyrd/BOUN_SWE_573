package com.bounfoodcoop.core.documents;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document
public @Data
class CommentDocument extends DocumentObject{
    private String title;
    private String content;
    private String user;
}
