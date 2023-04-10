package com.example.hamburgermenu;

import android.net.Uri;

public class DataClass {

    private Uri imageurl;



    public DataClass(Uri imageUri) {
        this.imageurl = imageurl;
    }

    public Uri getImageurl() {
        return imageurl;
    }

    public void setImageurl(Uri imageurl) {
        this.imageurl = imageurl;
    }
}