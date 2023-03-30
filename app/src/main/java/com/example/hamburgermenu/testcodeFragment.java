package com.example.hamburgermenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class testcodeFragment extends Fragment {

    ArrayList<news_banner> news_banners = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Home");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.news_recycle_view);
        setUpNewsBanner();
        RecycleViewAdapter adapter = new RecycleViewAdapter(this.getActivity() , news_banners);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));



        Button button1 = view.findViewById(R.id.homeButton1);
        Button button2 = view.findViewById(R.id.homeButton2);
        Button button3 = view.findViewById(R.id.homeButton3);
        Button button4 = view.findViewById(R.id.homeButton4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.FoodFragment);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.DiscussionsFragment);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.MarketplaceFragment);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.EventsFragment);
            }
        });
    }

    private void setUpNewsBanner() {
        String[] newsTitle = getResources().getStringArray(R.array.newsTitlesArray);
        String[] newsDate = getResources().getStringArray(R.array.newsDateArray);

        for ( int i =0; i<newsTitle.length; i++) {
            news_banners.add( new news_banner(newsTitle[i] , newsDate[i]));
        }
    }
}