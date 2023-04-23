package com.example.hamburgermenu.food;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.R;

import java.util.ArrayList;

public class RecycleViewAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Food_listing> Food_listings;

    public RecycleViewAdapter(Context context , ArrayList<Food_listing> Food_listings){
        this.context = context;
        this.Food_listings = Food_listings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout here, giving a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.food_recyclerview_row,parent,false);
        return new RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the food_recycler_view layout file
        // based on the position of the view
        holder.foodItem.setText(Food_listings.get(position).getFoodTitle());
        holder.location.setText(Food_listings.get(position).getLocation());
        holder.foodImage.setImageResource(Food_listings.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        // recycleView needs to know how many items we want displayed
        return Food_listings.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // like onCreate, we are grabbing views from our recycle_view_row layout file
        TextView foodItem;
        TextView location;
        ImageView foodImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodItem =  itemView.findViewById(R.id.food_item);
            location = itemView.findViewById(R.id.location);
            foodImage = itemView.findViewById(R.id.foodImage);
        }
    }


    public class ViewHolder {
        public ViewHolder(View view) {
        }
    }
}

//
//    This is a Java class named RecycleViewAdapter that extends the RecyclerView.Adapter class.
//    It's responsible for creating a custom adapter that will be used to display a list of news_banner
//    objects in a RecyclerView.
//
//    The adapter has a constructor that takes a Context and an ArrayList of news_banner objects.
//    The Context is used for inflating the layout for each row of the RecyclerView, while the
//    ArrayList contains the data that will be displayed.
//
//    The adapter overrides three methods:
//
//    onCreateViewHolder: This method is called when the RecyclerView needs a new ViewHolder
//    object to represent a row. It inflates the recycler_view_row layout file and returns
//    a new MyViewHolder object.
//
//    onBindViewHolder: This method is called to bind the data at a given position to a
//    MyViewHolder object. It retrieves the data for that position from the news_banners list
//    and assigns it to the appropriate TextView in the MyViewHolder object.
//
//    getItemCount: This method returns the number of items in the news_banners list,
//    which determines the number of rows in the RecyclerView.
//
//    The adapter also has a static inner class named MyViewHolder, which extends RecyclerView.
//    ViewHolder. It represents a single row in the RecyclerView and contains references to the
//    TextView objects in the recycler_view_row layout file. The MyViewHolder constructor retrieves references to these TextView objects using their respective IDs.
//
