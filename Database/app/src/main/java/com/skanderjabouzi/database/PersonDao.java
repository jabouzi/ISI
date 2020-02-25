package com.skanderjabouzi.database;

import android.database.Observable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person_table")
    LiveData<List<Person>> getAllPersons();

    @Query("SELECT * FROM person_table WHERE id = :id")
    LiveData<Person> getPerson(int id);

    @Insert(onConflict = REPLACE)
    void insert(Person person);

    @Query("DELETE FROM person_table WHERE id = :id")
    void delete(int id);

    @Query("DELETE FROM person_table")
    void deleteAll();

    @Query("SELECT COUNT(*) person_table")
    int getCount();

    @Update
    void update(Person person);
}
