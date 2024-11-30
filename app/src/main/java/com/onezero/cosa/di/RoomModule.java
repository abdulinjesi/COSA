package com.onezero.cosa.di;

import android.content.Context;

import com.onezero.cosa.data.room.dao.ServiceDao;
import com.onezero.cosa.data.room.database.AppDatabase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context context) {
        return AppDatabase.getDatabase(context);
    }

    @Provides
    public ServiceDao provideServiceDao(AppDatabase database) {
        return database.serviceDao();
    }
}
