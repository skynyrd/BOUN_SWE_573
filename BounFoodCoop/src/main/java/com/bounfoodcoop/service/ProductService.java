package com.bounfoodcoop.service;

import com.bounfoodcoop.domain.ProductDocument;
import com.bounfoodcoop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDocument getById(UUID uuid){
        return productRepository.findById(uuid);
    }

    public List<ProductDocument> getAllProducts(){
        return  productRepository.findAllByOrderByCreatedAtDesc();
    }

    public ProductDocument getPromotedProduct(String name){
        return productRepository.findByName(name);
    }
}
