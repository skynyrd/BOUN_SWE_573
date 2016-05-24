package com.bounfoodcoop.unittests;

import com.bounfoodcoop.core.documents.ProductDocument;
import com.bounfoodcoop.core.domain.*;
import com.bounfoodcoop.core.representation.ProductRepresentation;
import com.bounfoodcoop.repository.IProducerRepository;
import com.bounfoodcoop.repository.IProductRepository;
import com.bounfoodcoop.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.*;


public class WhenAddingANewProduct {
    IProductRepository mockRepository = mock(IProductRepository.class);
    ProductService productService;
    private Product expectedProductToBeAdded = new Product();

    @Before
    public void testSetup(){
        PrepareTestData();
        productService = new ProductService(mockRepository,  mock(IProducerRepository.class));
        productService.addProduct(new ProductRepresentation(expectedProductToBeAdded));
    }

    @Test
    public void repository_method_should_be_called(){
        verify(mockRepository).save(any(ProductDocument.class));
    }

    private void PrepareTestData() {
        Producer producer = new Producer();
        producer.setId(UUID.randomUUID());

        expectedProductToBeAdded.setProducer(producer);
        expectedProductToBeAdded.setId(UUID.randomUUID());
        expectedProductToBeAdded.setName("Edirne Ezine");
        expectedProductToBeAdded.setCategory(ProductCategory.DAIRY);
        expectedProductToBeAdded.setDescription("desc1");
        expectedProductToBeAdded.setPrice(12.3);
        expectedProductToBeAdded.setUnit(Unit.Gram);
        expectedProductToBeAdded.setUnitInStock(3);
        expectedProductToBeAdded.setStatus(ProductStatus.ACTIVE);
        expectedProductToBeAdded.setCity("mersin");
        expectedProductToBeAdded.setCreatedAt(new Date());
    }

}
