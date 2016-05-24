package com.bounfoodcoop.unittests;

import com.bounfoodcoop.core.documents.ProducerDocument;
import com.bounfoodcoop.core.documents.ProductDocument;
import com.bounfoodcoop.core.domain.Product;
import com.bounfoodcoop.core.domain.ProductCategory;
import com.bounfoodcoop.core.domain.ProductStatus;
import com.bounfoodcoop.core.domain.Unit;
import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.repository.IProductRepository;
import com.bounfoodcoop.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class WhenGettingAllProducts {
    IProductRepository mockRepository = mock(IProductRepository.class);
    ProductService productService;
    List<ProductDocument> testProductDocumentList;
    List<Product> resultProductList;
    private ProductDocument productDocument1;

    @Before
    public void testSetup(){
        PrepareTestData();
        when(mockRepository.findAllByOrderByCreatedAtDesc()).thenReturn(testProductDocumentList);
        productService = new ProductService(mockRepository,  mock(IProducerRepository.class));
        resultProductList = productService.getAllProducts();
    }

    @Test
    public void repository_method_should_be_called(){
        verify(mockRepository).findAllByOrderByCreatedAtDesc();
    }

    @Test
    public void two_products_should_return(){
        assertThat(resultProductList.size()).isEqualTo(2);
    }

    @Test
    public void first_product_should_have_correct_properties(){
        Product firstProduct = resultProductList.stream().findFirst().get();

        assertThat(firstProduct.getCity()).isEqualTo(productDocument1.getCity());
        assertThat(firstProduct.getName()).isEqualTo(productDocument1.getName());
        assertThat(firstProduct.getDescription()).isEqualTo(productDocument1.getDescription());
        assertThat(firstProduct.getPrice()).isEqualTo(productDocument1.getPrice());
        assertThat(firstProduct.getUnitInStock()).isEqualTo(productDocument1.getUnitInStock());
        assertThat(firstProduct.getCategory()).isEqualTo(ProductCategory.values()[productDocument1.getCategory()]);
        assertThat(firstProduct.getUnit()).isEqualTo(Unit.values()[productDocument1.getUnit()]);
        assertThat(firstProduct.getStatus()).isEqualTo(ProductStatus.values()[productDocument1.getStatus()]);
    }

    private void PrepareTestData() {
        testProductDocumentList = new ArrayList<>();
        ProducerDocument producer = new ProducerDocument();

        productDocument1 = new ProductDocument();
        productDocument1.setName("name1");
        productDocument1.setCategory(0);
        productDocument1.setDescription("desc1");
        productDocument1.setPrice(12.3);
        productDocument1.setUnit(0);
        productDocument1.setUnitInStock(3);
        productDocument1.setStatus(1);
        productDocument1.setCity("mersin");
        productDocument1.setProducer(producer);

        ProductDocument productDocument2 = new ProductDocument();
        productDocument2.setName("name2");
        productDocument2.setCategory(1);
        productDocument2.setDescription("desc2");
        productDocument2.setPrice(14.3);
        productDocument2.setUnit(0);
        productDocument2.setUnitInStock(3);
        productDocument2.setStatus(1);
        productDocument2.setCity("adana");
        productDocument2.setProducer(producer);

        testProductDocumentList.add(productDocument1);
        testProductDocumentList.add(productDocument2);
    }
}
