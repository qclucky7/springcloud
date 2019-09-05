package com.example.springcloud;

public enum StateCode {

    SUCCESS(1),

    FAIL(2);

    private int state;

    public int getState() {
        return state;
    }

    StateCode(int state) {
        this.state = state;
    }
}
