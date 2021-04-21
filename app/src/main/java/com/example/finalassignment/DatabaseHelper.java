package com.example.finalassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String db = "tourism";
    private static String t = "user";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, db, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + t + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + t);
        onCreate(db);
    }

    public boolean registerUser(String username, String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, username);
        values.put(COL_3, email);
        values.put(COL_4, password);


//        Cursor c = db.rawQuery("SELECT USERNAME FROM USER WHERE USERNAME = " + username, null);
//
//        if(c.getCount()>0)
//        {
//            return false;
//        }
//        else
//        {
        long result = db.insert(t, null, values);
        if (result == -1)
            return false;
        else
            return true;
//        }
    }

    public boolean checkUser(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = {COL_1};
        String selection = COL_2 + "=?" + " and " + COL_4 + "=?";
        String [] selectionArgs = {username, password};
        Cursor cursor = db.query(t, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;
    }
}
