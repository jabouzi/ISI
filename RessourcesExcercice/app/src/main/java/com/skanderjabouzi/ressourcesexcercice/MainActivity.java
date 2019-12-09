package com.skanderjabouzi.ressourcesexcercice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImage(View view) {
        EditText editText = findViewById(R.id.editText);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        String id = "img"+editText.getText().toString();
        String id2 = "image"+editText.getText().toString();

        int drawbleId = getResources().getIdentifier(id, "drawable", getPackageName());
        int stringId = getResources().getIdentifier(id2, "string", getPackageName());
        int colorId = getResources().getIdentifier(id2, "color", getPackageName());

        imageView.setImageDrawable(getResources().getDrawable(drawbleId));
        textView.setText(getResources().getString(stringId));
        textView.setTextColor(ContextCompat.getColor(this, colorId));


    }
}
