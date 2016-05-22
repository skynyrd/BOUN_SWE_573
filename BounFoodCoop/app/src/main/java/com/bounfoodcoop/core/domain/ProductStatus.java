package com.bounfoodcoop.core.domain;

public enum ProductStatus {
    ACTIVE(1), PASSIVE(0);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
