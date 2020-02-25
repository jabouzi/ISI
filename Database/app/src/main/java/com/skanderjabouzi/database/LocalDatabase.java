package com.skanderjabouzi.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
abstract class LocalDatabase extends RoomDatabase {
    abstract PersonDao personDao();
}
