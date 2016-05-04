package com.bounfoodcoop.service;

import com.bounfoodcoop.domain.*;
import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.repository.documents.ProductDocument;
import com.bounfoodcoop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;

@Service
public class DataLoader {

    private IProductRepository productRepository;
    private IProducerRepository producerRepository;

    @Autowired
    public DataLoader(IProductRepository postRepository, IProducerRepository producerRepository){
        this.productRepository = postRepository;
        this.producerRepository = producerRepository;
    }

    @PostConstruct
    private void loadData(){

        deleteAllData();

        Producer producer = new Producer("Hulki", "Yıldırım", "Kişisel", "0555555555", "Kayseri");
        ProductDocument product = new Product("Pastırma",
                Category.RED_MEAT,
                "21 Nisan'da kooperatifimize ulaşan çemensiz Kayseri pastırması.",
                65.5,
                Unit.Gram,
                producer,
                15000, ProductStatus.ACTIVE,
                "Kayseri",
                new Date()).ToDocument();


        Producer producer2 = new Producer("Seher", "Ödemiş", "Kişisel", "0555555555", "Edirne");
        ProductDocument product2 = new Product("Ezine Peyniri",
                Category.DAIRY,
                "Edirne'den gelen sert, orta tuzlu ezine peyniri",
                25.5,
                Unit.Gram,
                producer2,
                12000, ProductStatus.ACTIVE,
                "Edirne",
                new Date()).ToDocument();

        Producer producer3 = new Producer("Ali", "Yıldırım", "Kişisel", "0555555555", "İzmir");
        ProductDocument product3 = new Product("Bütün Tavuk",
                Category.WHITE_MEAT,
                "İzmir Buca'dan, doğal ortamda yetişmiş gezen tavuk",
                15.5,
                Unit.Quantity,
                producer3,
                21, ProductStatus.ACTIVE,
                "İzmir",
                new Date()).ToDocument();

        Producer producer4 = new Producer("Mahmut", "Yıldırım", "Kişisel", "0555555555", "Kars");
        ProductDocument product4 = new Product("Kars Gravyeri",
                Category.DAIRY,
                "Kars Gravyeri",
                25.5,
                Unit.Kg,
                producer4,
                0, ProductStatus.PASSIVE,
                "İzmir",
                new Date()).ToDocument();

        productRepository.save(Arrays.asList(product,product2,product3,product4));
        producerRepository.save(Arrays.asList(producer.ToDocument(), producer2.ToDocument(),
                producer3.ToDocument(), producer4.ToDocument()));
    }

    private void deleteAllData() {
        producerRepository.deleteAll();
        productRepository.deleteAll();
    }
}