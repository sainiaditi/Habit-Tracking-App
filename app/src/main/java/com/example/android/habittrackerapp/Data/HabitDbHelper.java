package com.example.android.habittrackerapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.habittrackerapp.Data.HabitContract.GuitarPractice;

/**
 * Created by Dell on 6/1/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "guitar.db";
    private final static int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_ALTER_TEAM_1 = "ALTER TABLE "
            + GuitarPractice.TABLE_NAME + " ADD COLUMN " + GuitarPractice.COLUMN_PRACTICE_DID + " string;";

    private static final String DATABASE_ALTER_TEAM_2 = "ALTER TABLE "
            + GuitarPractice.TABLE_NAME + " ADD COLUMN " + GuitarPractice.COLUMN_HOURS_PRACTICE + " string;";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_SQL ="CREATE TABLE " + GuitarPractice.TABLE_NAME
                + "(" + GuitarPractice._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GuitarPractice.COLUMN_PRACTICE_DID + " TEXT NOT NULL DEFAULT NO,"
                + GuitarPractice.COLUMN_PRACTICE_TIME_START + " TEXT DEFAULT 0.00,"
                + GuitarPractice.COLUMN_PRACTICE_TIME_END + " TEXT DEFAULT 0.00,"
                + GuitarPractice.COLUMN_HOURS_PRACTICE + "INTEGET DEFAULT 0);";
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i < 2) {
            sqLiteDatabase.execSQL(DATABASE_ALTER_TEAM_1);
        }
        if (i < 3) {
            sqLiteDatabase.execSQL(DATABASE_ALTER_TEAM_2);
        }
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GuitarPractice.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
