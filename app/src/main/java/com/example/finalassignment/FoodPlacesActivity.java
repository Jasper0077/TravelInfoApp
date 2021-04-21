package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FoodPlacesActivity extends AppCompatActivity {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imgUrls = new ArrayList<>();
    private ArrayList<String> ratings = new ArrayList<>();
    private ArrayList<String> labels = new ArrayList<>();
    private ArrayList<String> locations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_places);

        initImageBitmaps();



    }

    private void initImageBitmaps() {

        names.add("Chubbs Burger");
        imgUrls.add("https://planetkuching.com/upload/1593525570-2020-03-01.jpg");
        ratings.add("Rating: 5");
        labels.add("Western, Burger");
        locations.add("No 64, Jalan, Carpenter St, 93000 Kuching");

        names.add("Lepau Restaurant");
        imgUrls.add("https://media-cdn.tripadvisor.com/media/photo-s/08/40/3e/aa/lepau-entrance.jpg");
        ratings.add("Rating: 4");
        labels.add("Local, Asian. Malaysian");
        locations.add("395 Ban Hock Rd, 93400 Kuching");

        names.add("Toh Yuen");
        imgUrls.add("https://media-cdn.tripadvisor.com/media/photo-s/07/c9/a6/39/toh-yuen.jpg");
        ratings.add("Rating: 5");
        labels.add("Chinese, Fine Dining");
        locations.add("Jln Tunku Abdul Rahman, 93100 Kuching");

        names.add("The Junk");
        imgUrls.add("https://www.foodadvisor.my/attachments/66183a15111328e2956210f2e2c3c87b4cd5c42a/store/fill/800/500/bdc35ab517bdc45a254b21916b04f8c2983b57dd7349f2652b6bd6ea4103/featured_image.jpg");
        ratings.add("Rating: 5");
        labels.add("Western");
        locations.add("80, Wayang St, 93100 Kuching");

        initRecyclerView();

    }

    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.food_places_recycler_view);
        FoodPlacesAdapter adapter = new FoodPlacesAdapter(this, names, imgUrls, ratings, labels, locations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}