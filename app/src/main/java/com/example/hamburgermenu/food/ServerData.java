package com.example.hamburgermenu.food;

public class ServerData {
    static String[] foodTitleArray;
    static String[] locationArray;
    static String[] foodImageArray;

    //Constructor Method
    public ServerData(String[] foodTitleArray, String[] locationArray, String[] foodImageArray) {
        this.foodTitleArray = foodTitleArray;
        this.locationArray = locationArray;
        this.foodImageArray = foodImageArray;
    }

    public static String[] getFoodTitleArray() {
        return foodTitleArray;
    }

    public static String[] getLocationArray() {
        return locationArray;
    }

    public static String[] getFoodImageArray() {
        return foodImageArray;
    }
}
