package com.example.test123;

import java.time.LocalDateTime;

public class Mandate {
    private int ID;
    private String reason;
    private String date;
    private float amount;
    private int workerId;

    public Mandate(int ID, String reason, float amount, int workerId, String date){
        this.ID = ID;
        this.reason = reason;
        this.date = date;
        this.workerId = workerId;
        this.amount = amount;
    }
    public int getID() {
        return ID;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

}
