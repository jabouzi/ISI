package com.skanderjabouzi.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

        Intent intent = getIntent();
        String str = intent.getStringExtra("EXTRA_ACTIVITY1");
        textView.setText(str);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_ACTIVITY2", "Text from activity 2");
        setResult(RESULT_OK, intent);
        finish();
    }
}
