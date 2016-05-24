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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class WhenGettingPromotedProduct {
    IProductRepository mockRepository = mock(IProductRepository.class);
    ProductService productService;
    Product resultProduct;
    private ProductDocument testProductDocument;

    @Before
    public void testSetup(){
        PrepareTestData();
        when(mockRepository.findByName("Edirne Ezine")).thenReturn(testProductDocument);
        productService = new ProductService(mockRepository,  mock(IProducerRepository.class));
        resultProduct = productService.getPromotedProduct("Edirne Ezine");
    }

    @Test
    public void repository_method_should_be_called(){
        verify(mockRepository).findByName("Edirne Ezine");
    }

    @Test
    public void promoted_product_should_have_correct_properties(){
        assertThat(resultProduct.getCity()).isEqualTo(testProductDocument.getCity());
        assertThat(resultProduct.getName()).isEqualTo(testProductDocument.getName());
        assertThat(resultProduct.getDescription()).isEqualTo(testProductDocument.getDescription());
        assertThat(resultProduct.getPrice()).isEqualTo(testProductDocument.getPrice());
        assertThat(resultProduct.getUnitInStock()).isEqualTo(testProductDocument.getUnitInStock());
        assertThat(resultProduct.getCategory()).isEqualTo(ProductCategory.values()[testProductDocument.getCategory()]);
        assertThat(resultProduct.getUnit()).isEqualTo(Unit.values()[testProductDocument.getUnit()]);
        assertThat(resultProduct.getStatus()).isEqualTo(ProductStatus.values()[testProductDocument.getStatus()]);
    }

    private void PrepareTestData() {
        testProductDocument = new ProductDocument();
        testProductDocument.setName("Edirne Ezine");
        testProductDocument.setCategory(0);
        testProductDocument.setDescription("desc1");
        testProductDocument.setPrice(12.3);
        testProductDocument.setUnit(0);
        testProductDocument.setUnitInStock(3);
        testProductDocument.setStatus(1);
        testProductDocument.setCity("mersin");
        testProductDocument.setProducer(new ProducerDocument());
    }
}
