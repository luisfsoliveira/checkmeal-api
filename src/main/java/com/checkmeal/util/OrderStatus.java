package com.checkmeal.util;

public enum OrderStatus {

    OPEN(1),
    CANCELED(2),
    CLOSED(3);

    public final Integer status;

    private OrderStatus(Integer label) {
        this.status = label;
    }
}
