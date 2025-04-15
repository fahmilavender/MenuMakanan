package com.example.belajarrecyclerview;

public class Item {
    private String title;
    private String description;

    private String price;

    private int itemiImageView;

    public Item(String title, String description, String price, int itemiImageView) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.itemiImageView = itemiImageView;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getItemiImageView() {
        return itemiImageView;
    }
}

