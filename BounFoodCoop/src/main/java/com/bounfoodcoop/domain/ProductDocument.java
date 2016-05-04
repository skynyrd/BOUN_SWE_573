package com.bounfoodcoop.domain;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;


@Entity
public @Data class ProductDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String category;
    private String description;
    private double price;
    private String producer;
    private int unitInStock;
    private String status;
    private String city;
    private Date createdAt;
}
