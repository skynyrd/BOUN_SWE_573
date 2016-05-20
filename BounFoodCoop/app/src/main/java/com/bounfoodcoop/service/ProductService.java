package com.bounfoodcoop.service;

import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.repository.IProductRepository;
import documents.ProducerDocument;
import documents.ProductDocument;
import domain.*;
import domain.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import representation.ProductRepresentation;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IProducerRepository producerRepository;

    public ProductService(IProductRepository productRepository, IProducerRepository producerRepository) {
        this.productRepository = productRepository;
        this.producerRepository = producerRepository;
    }

    public Product getById(UUID uuid){
        Product product = new Product();
        product.Load(productRepository.findById(uuid));
        return product;
    }

    public List<Product> getAllProducts(){
        List<ProductDocument> productDocuments = productRepository.findAllByOrderByCreatedAtDesc();

        List<Product> products =
                productDocuments.stream().map(pd -> {
                    Product p = new Product();
                    p.Load(pd);
                    return p;
                }).collect(Collectors.toList());

        return products;
    }

    public Product getPromotedProduct(String name){
        Product product = new Product();
        product.Load(productRepository.findByName(name));
        return product;
    }

    public void addProduct(ProductRepresentation productRepresentation) {
        Producer producer = new Producer("Mahmut", "Tuncer", "Bireysel", "66464", "Mersin");
        producerRepository.save(producer.ToDocument());

        Product product = new Product(productRepresentation.getName(),
                 ProductCategory.values()[productRepresentation.getCategory()],
                productRepresentation.getDescription(),
                productRepresentation.getPrice(),
                Unit.values()[productRepresentation.getUnit()],
                producer,
                productRepresentation.getUnitInStock(),
                ProductStatus.values()[productRepresentation.getStatus()],
                productRepresentation.getCity()
                );

        productRepository.save(product.ToDocument());
    }

    public void deleteProduct(UUID productId) {
        productRepository.delete(productId);
    }
}
