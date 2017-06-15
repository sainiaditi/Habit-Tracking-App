package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewAnimationUtils;

import com.example.android.habittrackerapp.Data.HabitContract.GuitarPractice;


import com.example.android.habittrackerapp.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);

    }

    public void insertData(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GuitarPractice.COLUMN_PRACTICE_DID,GuitarPractice.DID_PRACTICE_YES);
        values.put(GuitarPractice.COLUMN_PRACTICE_TIME_START,"9:00 AM");
        values.put(GuitarPractice.COLUMN_PRACTICE_TIME_END,"11:00 AM");
        values.put(GuitarPractice.COLUMN_HOURS_PRACTICE,2);
        db.insert(GuitarPractice.TABLE_NAME,null,values);

        values.put(GuitarPractice.COLUMN_PRACTICE_DID,GuitarPractice.DID_PRACTICE_NO);
        db.insert(GuitarPractice.TABLE_NAME,null,values);
    }

    public Cursor readData(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                GuitarPractice.COLUMN_PRACTICE_DID,
                GuitarPractice.COLUMN_PRACTICE_TIME_START,
                GuitarPractice.COLUMN_PRACTICE_TIME_END,
                GuitarPractice.COLUMN_HOURS_PRACTICE
        };
        Cursor cursor = db.query(GuitarPractice.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }
}
