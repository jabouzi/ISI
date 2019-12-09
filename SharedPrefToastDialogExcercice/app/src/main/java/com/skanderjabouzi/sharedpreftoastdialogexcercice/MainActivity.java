package com.skanderjabouzi.sharedpreftoastdialogexcercice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView firstname;
    TextView lastname;
    TextView username;
    TextView password;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    public static final String firstnameKey = "firstnameKey";
    public static final String lastnameKey = "lastnameKey";
    public static final String usernameKey = "usernameKey";
    public static final String passwordKey = "passwordKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Please fill all fields");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });

        builder.show();
    }


    public void create(View view) {
        if (firstname.getText().toString().equals("") || lastname.getText().toString().equals("") || username.getText().toString().equals("") || password.getText().toString().equals("")) {
            showDialog();
        } else {
            editor.putString(firstnameKey, firstname.getText().toString());
            editor.putString(lastnameKey, lastname.getText().toString());
            editor.putString(usernameKey, username.getText().toString());
            editor.putString(passwordKey, password.getText().toString());
            editor.commit();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void cancel(View view) {
        firstname.setText("");
        lastname.setText("");
        username.setText("");
        password.setText("");
    }

}
