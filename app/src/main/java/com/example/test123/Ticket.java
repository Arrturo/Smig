package com.example.test123;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketType;
    private float price;
    private int count;
    private int line;
    private String creationDate;
    private String expirationDate;

    public Ticket(String ticketType, float price, String creationDate,int line, String expirationDate, int count) {
        this.ticketType = ticketType;
        this.price = price;
        this.line = line;
        this.expirationDate = expirationDate;
        this.count = count;
        this.creationDate = creationDate;
    }

    public String getTicketType() {
        return ticketType;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public int getLine() {
        return line;
    }

    public String getExpirationDate() {
        return expirationDate;
    }


    }
