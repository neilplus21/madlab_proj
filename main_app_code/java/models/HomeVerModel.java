package com.example.food_ordering_app.models;

public class HomeVerModel {
    int image;
    String name;
    String cat;
    String price;


    public HomeVerModel(int image, String name, String cat, String price) {
        this.image = image;
        this.name = name;
        this.cat = cat;
        this.price = price;
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
