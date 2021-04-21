package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    String username;
    EditText title, description;
    Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        addNote = findViewById(R.id.addNote);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null)
        {
            username = (String) b.get("username");
        }

        addNote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()))
                {
                    NotesDatabase db = new NotesDatabase(AddNoteActivity.this);
                    db.addNotes(username, title.getText().toString(), description.getText().toString());

                    Intent intent = new Intent(AddNoteActivity.this, NotesActivity.class);
                    intent.putExtra("username", username);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(AddNoteActivity.this, "Both Fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}