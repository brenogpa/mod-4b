package com.example.mod4b.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Product {

    public Product(int id, String description, double price, double stock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(){

    }

    public Integer id;

    public String description;

    public double price;

    public double stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
