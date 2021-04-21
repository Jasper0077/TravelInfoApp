package com.example.finalassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodPlacesAdapter extends RecyclerView.Adapter<FoodPlacesAdapter.ViewHolder>{

    private ArrayList<String> restaurantNames = new ArrayList<>();
    private ArrayList<String> restaurantImg = new ArrayList<>();
    private ArrayList<String> restaurantRatings = new ArrayList<>();
    private ArrayList<String> restaurantLabels = new ArrayList<>();
    private ArrayList<String> restaurantLocations = new ArrayList<>();
    private Context context;

    public FoodPlacesAdapter( Context context, ArrayList<String> restaurantNames, ArrayList<String> restaurantImg, ArrayList<String> restaurantRatings, ArrayList<String> restaurantLabels, ArrayList<String> restaurantLocations) {
        this.context = context;
        this.restaurantNames = restaurantNames;
        this.restaurantImg = restaurantImg;
        this.restaurantRatings = restaurantRatings;
        this.restaurantLabels = restaurantLabels;
        this.restaurantLocations = restaurantLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_food_places, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

           Glide.with(context)
                   .asBitmap()
                   .load(restaurantImg.get(position))
                   .into(holder.image);

           holder.name.setText(restaurantNames.get(position));
           holder.rating.setText(restaurantRatings.get(position));
           holder.label.setText(restaurantLabels.get(position));
           holder.location.setText(restaurantLocations.get(position));

           holder.layout_food_places.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Toast.makeText(context, restaurantNames.get(position), Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(context, FoodPlacesGalleryActivity.class);
                   intent.putExtra("image_url", restaurantImg.get(position));
                   intent.putExtra("image_name", restaurantNames.get(position));
                   context.startActivity(intent);
               }
           });

    }

    @Override
    public int getItemCount() {
        return restaurantNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name, rating, label, location;
        RelativeLayout layout_food_places;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.restaurant_img);
            name = itemView.findViewById(R.id.restaurant_name);
            rating = itemView.findViewById(R.id.restaurant_rating);
            label = itemView.findViewById(R.id.restaurant_label);
            location = itemView.findViewById(R.id.restaurant_location);
            layout_food_places = itemView.findViewById(R.id.layout_food_places);
        }
    }
}
