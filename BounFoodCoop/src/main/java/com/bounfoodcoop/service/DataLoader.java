package com.bounfoodcoop.service;

import com.bounfoodcoop.domain.ProductDocument;
import com.bounfoodcoop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;

@Service
public class DataLoader {

    private IProductRepository productRepository;

    @Autowired
    public DataLoader(IProductRepository postRepository){
        this.productRepository = postRepository;
    }

    @PostConstruct
    private void loadData(){
        ProductDocument product = new ProductDocument();
        product.setCategory("Kırmızı Et");
        product.setCity("Kayseri");
        product.setDescription("21 Nisan'da kooperatifimize ulaşan çemensiz Kayseri pastırması.");
        product.setName("Pastırma");
        product.setPrice(65.5);
        product.setProducer("Hulki Yıldırım");
        product.setStatus("Aktif");
        product.setCreatedAt(new Date());
        product.setUnitInStock(20);

        ProductDocument product2 = new ProductDocument();
        product2.setCategory("Süt Ürünleri");
        product2.setCity("Edirne");
        product2.setDescription("Edirne'den gelen sert, orta tuzlu ezine peyniri");
        product2.setName("Ezine Peyniri");
        product2.setPrice(25.5);
        product2.setProducer("Seher Ödemiş");
        product2.setStatus("Aktif");
        product2.setCreatedAt(new Date());
        product2.setUnitInStock(40);

        ProductDocument product3 = new ProductDocument();
        product3.setCategory("Beyaz Et");
        product3.setCity("İzmir");
        product3.setDescription("İzmir Buca'dan, doğal ortamda yetişmiş gezen tavuk");
        product3.setName("Bütün Tavuk");
        product3.setPrice(15.5);
        product3.setProducer("Hulki Yıldırım");
        product3.setStatus("Aktif");
        product3.setCreatedAt(new Date());
        product3.setUnitInStock(15);

        ProductDocument product4 = new ProductDocument();
        product4.setCategory("Süt Ürünleri");
        product4.setCity("Kars");
        product4.setDescription("Kars Gravyeri");
        product4.setName("Kars Gravyeri");
        product4.setPrice(25.5);
        product4.setProducer("Seher Ödemiş");
        product4.setStatus("Aktif");
        product4.setCreatedAt(new Date());
        product4.setUnitInStock(40);

        productRepository.save(Arrays.asList(product,product2,product3,product4));
    }
}