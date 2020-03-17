package com.example.springcloud;

public enum StateCode {

    SUCCESS(1,1),

    FAIL(2,2);

    private int state;
    private int type;

    public int getType() {
        return type;
    }
    public int getState() {
        return state;
    }

    StateCode(int state, int type) {
        this.state = state;
        this.type = type;
    }
}
