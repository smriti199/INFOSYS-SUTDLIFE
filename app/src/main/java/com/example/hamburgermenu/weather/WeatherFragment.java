package com.example.hamburgermenu.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.hamburgermenu.R;


public class WeatherFragment extends Fragment {

    // API Key -- ea0d26bf4bec419ca07a468a48877199

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button home = view.findViewById(R.id.buttontohome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.HomeFragment);
            }
        });
    }
}