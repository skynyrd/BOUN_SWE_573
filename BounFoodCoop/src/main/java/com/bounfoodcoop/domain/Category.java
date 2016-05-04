package com.bounfoodcoop.domain;

public enum Category {
    RED_MEAT(0), WHITE_MEAT(1), DAIRY(2), VEGETABLE(3), FRUIT(4), OTHER(5);

    private int value;
    Category(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
