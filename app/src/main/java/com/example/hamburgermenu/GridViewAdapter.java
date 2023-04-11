package com.example.hamburgermenu;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder>{
    // ViewHolder is a wrapper (able to call onto multiple f(x)) that contains the layout for an individual item in the list
    // The Adapter (GridViewAdapter) creates ViewHolder objects as needed and sets data for those views. Hence we associate views to their data
    ArrayList<String> titles;
    ArrayList<Integer> images;
    LayoutInflater inflater; // custom layout design

    // Constructor for the class below
    public GridViewAdapter(Context context, ArrayList<String> titles, ArrayList<Integer> images) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.ViewHolder holder, int position) {
            Log.d("RecyclerViewAdapter", "Binding item at position: " + position);
            holder.title.setText(titles.get(position));
            holder.image.setImageResource(images.get(position));

        holder.title.setText(titles.get(position));
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return  images.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            image = itemView.findViewById(R.id.imageView2);
        }
    }
}
