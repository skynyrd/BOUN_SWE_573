package com.bounfoodcoop.core.domain;

public enum PostCategory {
    ANNOUNCEMENT(0), NEWS(1), ACTIVITY(2);

    private int value;
    PostCategory(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
