package com.skanderjabouzi.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class LocalDataSource {

    private String DB_NAME = "person_table";

    private LocalDatabase personDatabase;
    public LocalDataSource(Context context) {
        personDatabase = Room.databaseBuilder(context, LocalDatabase.class, DB_NAME).build();
    }

    public void insertTask(String firstname,
                           String lastname,
                           int age) {

        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setAge(age);
        insertTask(person);
    }

    public void insertTask(final Person person) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                personDatabase.personDao().insert(person);
                return null;
            }
        }.execute();
    }

    public void updateTask(final Person person) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                personDatabase.personDao().update(person);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<Person> task = getTask(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    personDatabase.personDao().delete(id);
                    return null;
                }
            }.execute();
        }
    }

    public LiveData<Person> getTask(int id) {
        return personDatabase.personDao().getPerson(id);
    }

    public LiveData<List<Person>> getTasks() {
        return personDatabase.personDao().getAllPersons();
    }

    public int getCount() {
        return personDatabase.personDao().getCount();
    }
}
