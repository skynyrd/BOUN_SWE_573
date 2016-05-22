package com.bounfoodcoop.service;

import com.bounfoodcoop.repository.ICommentRepository;
import com.bounfoodcoop.repository.IPostRepository;
import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.repository.IProductRepository;
import com.bounfoodcoop.core.documents.ProductDocument;
import com.bounfoodcoop.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataLoader {

    private IProductRepository productRepository;
    private IProducerRepository producerRepository;
    private IPostRepository postRepository;
    private ICommentRepository commentRepository;

    @Autowired
    public DataLoader(IProductRepository productRepository,
                      IProducerRepository producerRepository,
                      IPostRepository postRepository,
                      ICommentRepository commentRepository){
        this.productRepository = productRepository;
        this.producerRepository = producerRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @PostConstruct
    private void loadData(){
        deleteAllData();
        CreateProducersAndProducts();
        CreatePostsAndComments();
    }

    private void CreatePostsAndComments() {
        Comment comment = new Comment("Kaçırmayın", "Dün aldım çok iyi çıktı, tavsiye ederim.", "Suzan Üsküdarlı");

        List<Comment> commentsOfPost = new ArrayList<>();
        commentsOfPost.add(comment);

        Post post = new Post("Organik Tavuklar Kooperatifimize Ulaştı","İzmir'den " +
                "gelen organik bütün tavuklarımız kooperatifimize ulaşmış bulunmaktadır.",
                commentsOfPost, PostCategory.NEWS);

        postRepository.save(post.ToDocument());
        commentRepository.save(comment.ToDocument());
    }

    private void CreateProducersAndProducts() {
        Producer producer = new Producer("Hulki", "Yıldırım", "Kişisel", "0555555555", "Kayseri");
        ProductDocument product = new Product("Pastırma",
                ProductCategory.RED_MEAT,
                "21 Nisan'da kooperatifimize ulaşan çemensiz Kayseri pastırması.",
                65.5,
                Unit.Gram,
                producer,
                15000, ProductStatus.ACTIVE,
                "Kayseri").ToDocument();


        Producer producer2 = new Producer("Seher", "Ödemiş", "Kişisel", "0555555555", "Edirne");
        ProductDocument product2 = new Product("Ezine Peyniri",
                ProductCategory.DAIRY,
                "Edirne'den gelen sert, orta tuzlu ezine peyniri",
                25.5,
                Unit.Gram,
                producer2,
                12000, ProductStatus.ACTIVE,
                "Edirne").ToDocument();

        Producer producer3 = new Producer("Ali", "Yıldırım", "Kişisel", "0555555555", "İzmir");
        ProductDocument product3 = new Product("Bütün Tavuk",
                ProductCategory.WHITE_MEAT,
                "İzmir Buca'dan, doğal ortamda yetişmiş gezen tavuk",
                15.5,
                Unit.Quantity,
                producer3,
                21, ProductStatus.ACTIVE,
                "İzmir").ToDocument();

        Producer producer4 = new Producer("Mahmut", "Yıldırım", "Kişisel", "0555555555", "Kars");
        ProductDocument product4 = new Product("Kars Gravyeri",
                ProductCategory.DAIRY,
                "Kars Gravyeri",
                25.5,
                Unit.Kg,
                producer4,
                0, ProductStatus.PASSIVE,
                "İzmir").ToDocument();

        productRepository.save(Arrays.asList(product,product2,product3,product4));
        producerRepository.save(Arrays.asList(producer.ToDocument(), producer2.ToDocument(),
                producer3.ToDocument(), producer4.ToDocument()));
    }

    private void deleteAllData() {
        producerRepository.deleteAll();
        productRepository.deleteAll();
    }
}