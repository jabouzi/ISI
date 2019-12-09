package com.skanderjabouzi.sharedpreftoastdialogexcercice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void login(View view) {
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        String savedUname = sharedpreferences.getString(MainActivity.usernameKey, "");
        String savedPass = sharedpreferences.getString(MainActivity.passwordKey, "");
        String savedFname = sharedpreferences.getString(MainActivity.firstnameKey, "");
        String savedLname = sharedpreferences.getString(MainActivity.lastnameKey, "");

        if (uname.equals("") || pass.equals("")) {
            showToast("Login failed");
        } else if (uname.equals(savedUname) && pass.equals(savedPass)) {
                showToast("Login success: " + savedFname + " - " + savedLname);

        } else {
        showToast("Login failed");
        }
    }
}
