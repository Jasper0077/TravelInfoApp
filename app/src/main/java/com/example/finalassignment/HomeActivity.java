package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    private ImageView attractionBtn, eatBtn, mapBtn, noteBtn, searchBtn, eventBtn, logoutBtn;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        attractionBtn = findViewById(R.id.img_attraction);
        eatBtn = findViewById(R.id.img_eat);
        mapBtn = findViewById(R.id.img_map);
        noteBtn = findViewById(R.id.img_note);
        searchBtn = findViewById(R.id.img_web_search);
        eventBtn = findViewById(R.id.img_event);
        logoutBtn = findViewById(R.id.btn_logout);

        username = findViewById(R.id.username);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null)
        {
            username.setText((String)b.get("username"));
        }
//        if (sharedPreferences.contains("name")) {
//            username.setText(sharedPreferences.getString("name", ""));
//        }

        eatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FoodPlacesActivity.class);
//                intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });

        attractionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AttractionActivity.class);
                intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                //intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });


        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 1.55 110.33333"));
                startActivity(intent);
            }
        });

        noteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotesActivity.class);
                intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                //intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });

        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EventActivity.class);
                intent.putExtra("username", username.getText().toString());

                startActivity(intent);
            }
        });
    }
}