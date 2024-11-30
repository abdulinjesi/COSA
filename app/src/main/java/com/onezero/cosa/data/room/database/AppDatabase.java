package com.onezero.cosa.data.room.database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.onezero.cosa.data.room.dao.ServiceDao;
import com.onezero.cosa.data.room.model.Service;

@Database(
        entities = {
                Service.class,
        },
        version = 2,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE = null;

    // DAO declarations
    public abstract ServiceDao serviceDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                   "cosa"
                            )
                            .fallbackToDestructiveMigration() // In case of schema migration issues
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
