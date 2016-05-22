package com.bounfoodcoop.core.domain.exception;

import lombok.extern.log4j.Log4j;

import java.util.UUID;

@Log4j
public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(UUID productId) {
        log.error(String.format("Product with id %s not found", productId));
    }
}