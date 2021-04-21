package com.example.finalassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NotesDatabase extends SQLiteOpenHelper {

    Context context;
    private static String db = "tourism";
    private static String t = "notes";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "TITLE";
    private static final String COL_4 = "DESCRIPTION";



    public NotesDatabase(@Nullable Context context) {
        super(context, db, null, 3);
        //getReadableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        String query = "CREATE TABLE IF NOT EXISTS " + t +
//                " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COL_2 + " TEXT," +
//                COL_3 + " TEXT," +
//                COL_4 + " TEXT)";

        db.execSQL("CREATE TABLE IF NOT EXISTS " + t + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, TITLE TEXT, DESCRIPTION TEXT)");

        //Toast.makeText(this.context, "Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + t);
        onCreate(db);
    }

    void addNotes(String username, String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2, username);
        cv.put(COL_3, title);
        cv.put(COL_4, description);

        long resultValue = db.insert(t, null, cv);

        if (resultValue == -1)
        {
            Toast.makeText(context, "Data Not Added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Added successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(String username)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        database.execSQL("CREATE TABLE IF NOT EXISTS " + t + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, TITLE TEXT, DESCRIPTION TEXT)");
        String query = "SELECT * FROM notes WHERE USERNAME = '"+username+"'";
                //+ t +
        //" WHERE USERNAME = '"+username+"'";

        Cursor cursor = null;
        if (database != null)
        {
            cursor = database.rawQuery(query, null);
        }
        return cursor;
    }

    void deleteAllNotes(String username)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "DELETE FROM " + t + " WHERE USERNAME = '"+username+"'";
        database.execSQL(query);
    }

    void updateNote(String title, String description, String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_3, title);
        cv.put(COL_4, description);

        long result = db.update(t, cv, "ID=?", new String[]{id});
        if (result == -1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteSingleItem(String id)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        long result = database.delete(t, "ID=?", new String[]{id});
        if (result == -1)
        {
            Toast.makeText(context, "Item Not Deleted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}
