package com.skanderjabouzi.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText city;
    EditText country;
    Button save;

    CityDataSource cityDataSource;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        city = findViewById(R.id.city);
        country = findViewById(R.id.country);

        cityDataSource = new CityDataSource(this);
        if (!cityDataSource.isOpen()) cityDataSource.open();
    }

    public void save(View view) {
        City cityObj = new City();
        cityObj.setId(cityDataSource.getCityCount() + 1);
        cityObj.setCity(city.getText().toString());
        cityObj.setCountry(country.getText().toString());
        cityDataSource.addCity(cityObj);
        finish();
    }
}
