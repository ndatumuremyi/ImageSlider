package com.example.imageslider.model;

import android.util.Log;

import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class EventC {
    private String name;
    private String date;
    private String location;
    private ArrayList<Category> categories = new ArrayList<>();
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public EventC() {
    }

    public EventC(String name, String date, String location, ArrayList<Category> categories) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
    public void print(){
        Log.d("Print", "event name " + name);
        Log.d("Print", "date " + date);
        Log.d("Print", "location" + location);

        for(Category c : categories){
            c.print();
        }
    }
}
