package com.bounfoodcoop.service;

import com.bounfoodcoop.domain.Product;
import com.bounfoodcoop.repository.documents.ProductDocument;
import com.bounfoodcoop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
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
}
