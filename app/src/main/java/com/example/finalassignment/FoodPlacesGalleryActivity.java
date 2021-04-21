package com.example.finalassignment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FoodPlacesGalleryActivity extends AppCompatActivity {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_places_gallery);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);


        }
    }

    private void setImage(String imageUrl, String imageName) {

        TextView name = findViewById(R.id.food_places_img_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.food_places_img);

        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
