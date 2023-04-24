package com.example.hamburgermenu;

import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hamburgermenu.food.FoodFragment;
import com.example.hamburgermenu.market.MarketplaceFragment;
import com.example.hamburgermenu.news.NewsFragment;
import com.example.hamburgermenu.weather.WeatherFragment;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add( new SlideModel(R.drawable.sutd_campus, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community1, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community2, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        CardView dashFood = findViewById(R.id.dashboardFood);
        CardView dashMarketplace = findViewById(R.id.dashboardMarketplace);
        CardView dashEvents = findViewById(R.id.dashboardEvents);
        CardView dashDiscussions = findViewById(R.id.dashboardDiscussions);

        dashFood.setOnClickListener(this);
        dashMarketplace.setOnClickListener(this);
        dashEvents.setOnClickListener(this);
        dashDiscussions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dashboardFood:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new FoodFragment()).commit();
                break;
            case R.id.dashboardMarketplace:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new MarketplaceFragment()).commit();
                break;
            case R.id.dashboardEvents:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new NewsFragment()).commit();
                break;
            case R.id.dashboardDiscussions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new WeatherFragment()).commit();
                break;
        }
    }
}
