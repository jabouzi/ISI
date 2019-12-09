package com.skanderjabouzi.week2demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("TEXT"));
        }

        textView.setText(sharedPreferences.getString("STRING", ""));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TEXT", textView.getText().toString());
    }



    public void click(View view) {
        textView.setText("set text to texView");
        editText.setText("set text to texView");
        editor.putString("STRING", textView.getText().toString());
        editor.commit();

//        Toast.makeText(this, "This a message from a taost long", Toast.LENGTH_LONG).show();
//        Toast.makeText(this, "This a message from a taost short", Toast.LENGTH_SHORT).show();

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(false);
//        builder.setTitle("Dialog title");
//        builder.setMessage("Dialog message goes here");
//        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(), "Cancel button clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(), "OK button clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        AlertDialog dialog = builder.show();
    }
}
