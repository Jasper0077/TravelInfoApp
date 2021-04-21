package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateNotesActivity extends AppCompatActivity {

    EditText title, description;
    String id, username;
    Button updateNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        updateNote = findViewById(R.id.updateNote);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null)
        {
            title.setText((String) b.get("title"));
            description.setText((String) b.get("description"));
            id = (String) b.get("id");
            username = (String) b.get("username");
        }

        updateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()))
                {
                    NotesDatabase db = new NotesDatabase(UpdateNotesActivity.this);
                    db.updateNote(title.getText().toString(), description.getText().toString(), id);

                    Intent intent = new Intent(UpdateNotesActivity.this, NotesActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}