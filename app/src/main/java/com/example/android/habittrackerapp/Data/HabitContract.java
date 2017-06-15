package com.example.android.habittrackerapp.Data;

import android.provider.BaseColumns;

/**
 * Created by Dell on 6/1/2017.
 */

public final class HabitContract {
    private HabitContract(){
        throw new AssertionError("No HabitContract instances for you!");
    }

    public static class GuitarPractice implements BaseColumns{
        public final static String TABLE_NAME = "guitar";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRACTICE_DID = "Did_Practice";
        public final static String COLUMN_PRACTICE_TIME_START = "Start_Time";
        public final static String COLUMN_PRACTICE_TIME_END = "End_Time";
        public final static String COLUMN_HOURS_PRACTICE = "Practice_Hours";

        public static final int DID_PRACTICE_YES = 1;
        public static final int DID_PRACTICE_NO = 0;
    }
}
