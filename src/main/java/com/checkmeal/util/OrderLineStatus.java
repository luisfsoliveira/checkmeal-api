package com.checkmeal.util;

public enum OrderLineStatus {

    DRAFT(1),
    PREPARATION(2),
    READY_DELIVER(3),
    DELIVERED(4);

    public final int status;

    private OrderLineStatus(int status) {
        this.status = status;
    }
}
