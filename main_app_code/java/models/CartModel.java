package com.example.food_ordering_app.models;

public class CartModel {
    int image;
    String name;
    String price;
    String quantity;

    public CartModel(String quantity, String price, String name, int image) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
