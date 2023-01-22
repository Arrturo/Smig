package com.example.test123;

public class TicketInOffer {
    float price;
    String type;
    int time;

    public TicketInOffer(String type, float price, int time) {
        this.price = price;
        this.type = type;
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getTime() {
        return time;
    }
}
