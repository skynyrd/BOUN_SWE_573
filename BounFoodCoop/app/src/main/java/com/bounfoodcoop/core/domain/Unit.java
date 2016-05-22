package com.bounfoodcoop.core.domain;

public enum Unit {
    Kg(0), Gram(1), Package(2), Quantity(3);

    private int value;
    Unit(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
