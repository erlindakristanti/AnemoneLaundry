package com.azhar.laundry.database;

import android.content.Context;

import androidx.room.Room;

import com.google.firebase.firestore.FirebaseFirestore;

public class DatabaseClient {

    private static DatabaseClient mInstance;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    AppDatabase mAppDatabase;

    private DatabaseClient(Context context) {
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, "laundry_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
