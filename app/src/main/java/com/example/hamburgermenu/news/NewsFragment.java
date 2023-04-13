package com.example.hamburgermenu.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hamburgermenu.MainActivity;
import com.example.hamburgermenu.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link NewsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class NewsFragment extends Fragment {

    // 3097564f2dcb4bf19a6dd99da72f774f -> API KEY
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).setActionBarTitle("Events");
        return inflater.inflate(R.layout.fragment_news_main, container, false);
    }


//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        Button home = view.findViewById(R.id.buttontohome);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate( R.id.HomeFragment);
//            }
//        });
//    }
}