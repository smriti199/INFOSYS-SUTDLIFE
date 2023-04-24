package com.example.hamburgermenu.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.R;

import java.util.ArrayList;

public class FoodFragment extends Fragment implements FetchDataTask.DataListener {
    ArrayList<Food_listing> food_listings = new ArrayList<>();

    int[] food_images = {R.drawable.hamburger, R.drawable.japanese_sandwiches, R.drawable.chicken_rice,
            R.drawable.ban_mian, R.drawable.nasi_lemak, R.drawable.pizza, R.drawable.herbal_chicken_soup,
            R.drawable.mala_hotpot};

    RecycleViewAdapter<RecyclerView.ViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        // Inflate the layout for this fragment -- food fragment which simply contains the recyclerview
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.food_recycler_view);
        setUpFoodListings();
        RecycleViewAdapter adapter = new RecycleViewAdapter(getContext(), food_listings);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button home = view.findViewById(R.id.buttontohome);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.HomeFragment);
            }
        });
        Button createPost = view.findViewById(R.id.createTweet);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.tweetFragment);
            }
        });

        FetchDataTask task = new FetchDataTask();
        task.setListener((FetchDataTask.DataListener) this); // Set the listener to this activity
        task.execute(); // Start the task
    }

    // local implementation
    private void setUpFoodListings() {
        String[] foodTitleArray = getResources().getStringArray(R.array.foodTitleArray);
        String[] foodLocationArray = getResources().getStringArray(R.array.locationArray);

        for (int i=0; i< foodTitleArray.length; i++) {
            food_listings.add(new Food_listing(foodTitleArray[i], foodLocationArray[i], food_images[i])); // an array of Food_listing objects
        }
    }

    // for real time database implementation


    @Override
    public void onDataFetched(ServerData data) {
        // This method will be called when the data is fetched
        String[] foodTitleArray = data.getFoodTitleArray();
        String[] locationArray = data.getLocationArray();
        String[] foodImageArray = data.getFoodImageArray();

//        setUpFoodListings(foodTitleArray, locationArray, foodImageArray);
//
//        recyclerView = getView().findViewById(R.id.news_recycle_view);
//        adapter = new RecycleViewAdapter<RecyclerView.ViewHolder>(this.getActivity(), food_listings);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
//    }



    }
}

//    private void setUpFoodListings(String[] foodTitleArray, String[] locationArray, String[]foodImageArray ) {
//        for (int i = 0; i < foodTitleArray.length; i++) {
//            news_banners.add(new news_banner(newsTitleArray[i], newsDateArray[i])); //news_banner is a new array
//        }
//    }
//}
