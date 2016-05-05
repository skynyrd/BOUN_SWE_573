package com.bounfoodcoop.domain;


import com.bounfoodcoop.repository.documents.ProductDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public @Data class Product extends BaseDomainObject<ProductDocument> {

    private String name;
    private ProductCategory category;
    private String description;
    private double price;
    private Unit unit;
    private Producer producer;
    private int unitInStock;
    private ProductStatus status;
    private String city;

    public Product(){}

    public Product(String name, ProductCategory category, String description, double price, Unit unit,
                   Producer producer, int unitInStock, ProductStatus status, String city) {

        this.Id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.producer = producer;
        this.unitInStock = unitInStock;
        this.status = status;
        this.city = city;
        this.createdAt = new Date();
    }

    @Override
    public ProductDocument ToDocument() {
        ProductDocument productDocument = new ProductDocument();

        productDocument.setId(this.Id);
        productDocument.setCategory(this.category.getValue());
        productDocument.setName(this.name);
        productDocument.setDescription(this.description);
        productDocument.setPrice(this.price);
        productDocument.setUnit(this.unit.getValue());
        productDocument.setProducer(this.producer.ToDocument());
        productDocument.setUnitInStock(this.unitInStock);
        productDocument.setStatus(this.status.getValue());
        productDocument.setCity(this.city);
        productDocument.setCreatedAt(this.createdAt);
        return productDocument;
    }

    @Override
    public void Load(ProductDocument productDocument) {

        Producer p = new Producer();
        p.Load(productDocument.getProducer());
        this.producer = p;

        this.Id = productDocument.getId();
        this.name = productDocument.getName();
        this.category = ProductCategory.values()[productDocument.getCategory()];
        this.description = productDocument.getDescription();
        this.price = productDocument.getPrice();
        this.unit = Unit.values()[productDocument.getUnit()];
        this.unitInStock = productDocument.getUnitInStock();
        this.status = ProductStatus.values()[productDocument.getStatus()];
        this.city = productDocument.getCity();
        this.createdAt = productDocument.getCreatedAt();
    }
}
