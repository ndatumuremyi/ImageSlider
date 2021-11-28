package com.example.imageslider.model;

import android.util.Log;

public class Category {
    private String name;
    private int numberOfTicket;
    private int price;

    public Category() {
    }

    public Category(String name, int numberOfTicket, int price) {
        this.name = name;
        this.numberOfTicket = numberOfTicket;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print() {
        Log.d("Print", "C name "+name);
        Log.d("Print", "nu of t" + numberOfTicket);
        Log.d("Print",  "price " + price);
    }
}
