package com.example.hamburgermenu.food;

import android.widget.ImageView;

public class Food_listing {
    String foodTitle;
    String location;
    int foodImage;

    public Food_listing(String foodTitle, String location, int foodImage) {
        this.foodTitle = foodTitle;
        this.location = location;
        this.foodImage = foodImage;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public String getLocation() {
        return location;
    }

    public int getFoodImage() {
        return foodImage;
    }
}
