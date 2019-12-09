package com.skanderjabouzi.dialogpreftoast;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener   {

    TextView textView;
    TextView text1;
    TextView text2;
    Button button1;
    Button button2;
    Button button3;
    Button save;
    Button retrieve;
    Button clear;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    public static final String mypreference = "mypref";
    public static final String text1Key = "text1Key";
    public static final String text2Key = "text2Key";

    final static String RANDOM_NUMBER = "RANDOM_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        save = findViewById(R.id.save);
        retrieve = findViewById(R.id.retrieve);
        clear = findViewById(R.id.clear);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(RANDOM_NUMBER));
        }

        button3.setOnClickListener(this);

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RANDOM_NUMBER, textView.getText().toString());
    }

    public void button1Clicked(View view) {
        textView.setText(generaterandomNumber());
    }

    private String generaterandomNumber() {
        Random r = new Random();
        return String.valueOf(r.nextInt());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button3) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("EXTRA", "some text");
            intent.putExtra("EXTRA2", 100);
            startActivity(intent);
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is an alert dialog example");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        AlertDialog dialog = builder.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void Save(View view) {
        String str1 = text1.getText().toString();
        String str2 = text2.getText().toString();
        editor = sharedpreferences.edit();
        editor.putString(text1Key, str1);
        editor.putString(text2Key, str2);
        editor.commit();
        showToast("Data saved with success");
    }


    public void Retrieve(View view) {
        String str1 = sharedpreferences.getString(text1Key, "");
        String str2 = sharedpreferences.getString(text2Key, "");
        text1.setText(str1);
        text2.setText(str2);
        showToast("Data retrived with success");
    }

    public void Clear(View view) {
        text1.setText("");
        text2.setText("");
        showToast("Edit texts cleared with success");
    }

    public void delete1(View view) {
        editor.remove(text1Key).commit();
        showToast("Data # 1 deleted with success");
    }

    public void delete2(View view) {
        editor.remove(text2Key).commit();
        showToast("Data # 2 deleted with success");
    }


    public void deleteAll(View view) {
        editor.clear().commit();
        showToast("All data deleted with success");
    }
}
