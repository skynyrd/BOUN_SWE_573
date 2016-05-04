package com.bounfoodcoop.repository.documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
public @Data class ProductDocument extends DocumentObject {
    private String name;
    private int category;
    private int unit;
    private String description;
    private double price;

    @DBRef
    private ProducerDocument producer;

    private int unitInStock;
    private int status;
    private String city;
    private Date createdAt;
}
