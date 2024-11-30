package com.onezero.cosa.data.room.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "service_table")
public class Service {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;
    public String likes;
    public Service(String name, String description, String likes) {
        this.name = name;
        this.description = description;
        this.likes = likes;
    }
}
