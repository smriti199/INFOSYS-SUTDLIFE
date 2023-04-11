package com.example.hamburgermenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MarketplaceFragment extends Fragment {
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();

    Button CreateListing;

    private GridViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home2, container, false);
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setActionBarTitle("Market Place");
        }


        RecyclerView dataList = rootView.findViewById(R.id.dataList); // retrieve RecyclerView type dataList from fragment_home2.xml file
        dataList.setVisibility(View.VISIBLE);
        dataList.setHasFixedSize(true);
        dataList.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));

        titles.add("Arduino Uno");
        titles.add("Corsair RM 650W");
        titles.add("DDR4 64GB RAM");
        titles.add("Raspberry pi 4");
        titles.add("Wires");
        titles.add("8x8 LED Matrix");


        images.add(R.drawable.arduino_uno);
        images.add(R.drawable.corsair_rm650);
        images.add(R.drawable.corsair_ddr4_64gb_ram);
        images.add(R.drawable.raspberry_pi_4);
        images.add(R.drawable.wire);
        images.add(R.drawable.arduino_led_matrix);

        // Connect MarketPlace database to this fragment, create a PULL request to firebase server to obtain information on titles and images
        //

        adapter = new GridViewAdapter(getContext(), titles, images);
        dataList.setAdapter(adapter);
        loadData();



        return rootView;
    }

    private void loadData() {
        // Do some work to populate the data list

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
//        Button home = view.findViewById(R.id.buttontohome);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate( R.id.HomeFragment);
//            }
//        });
       RecyclerView dataList = getView().findViewById(R.id.dataList);
       dataList.setLayoutManager(new GridLayoutManager(getActivity(), 2));


       CreateListing = view.findViewById(R.id.create_listing);

       CreateListing.setOnClickListener(new View.OnClickListener() {

       });
    }
}