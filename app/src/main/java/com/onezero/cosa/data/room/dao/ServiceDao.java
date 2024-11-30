package com.onezero.cosa.data.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.onezero.cosa.data.room.model.Service;

import java.util.List;
@Dao
public interface ServiceDao {

    // Insert a new service into the database
    @Insert
    void insertService(Service service);
    // Fetch all services from the database
    @Query("SELECT * FROM service_table")
    LiveData<List<Service>> getAllServices();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Service> res);
}