package com.skanderjabouzi.simplecalculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText number1;
    EditText number2;
    TextView result;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMul;
    Button buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);
        buttonAdd = findViewById(R.id.add);
        buttonSub = findViewById(R.id.sub);
        buttonMul = findViewById(R.id.mul);
        buttonDiv = findViewById(R.id.div);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add) {
            addOperation();
        } else if (view.getId() == R.id.sub) {
            subOperation();
        } else if (view.getId() == R.id.mul) {
            mulOperation();
        } else {
            divOperation();
        }
    }

    private void addOperation() {
        int nb1 = Integer.parseInt(number1.getText().toString());
        int nb2 = Integer.parseInt(number2.getText().toString());

        result.setText(String.valueOf(nb1 + nb2));

    }

    private void subOperation() {
        int nb1 = Integer.parseInt(number1.getText().toString());
        int nb2 = Integer.parseInt(number2.getText().toString());

        result.setText(String.valueOf(nb1 - nb2));
    }

    private void mulOperation() {
        int nb1 = Integer.parseInt(number1.getText().toString());
        int nb2 = Integer.parseInt(number2.getText().toString());

        result.setText(String.valueOf(nb1 * nb2));
    }

    private void divOperation() {
        int nb1 = Integer.parseInt(number1.getText().toString());
        int nb2 = Integer.parseInt(number2.getText().toString());

        result.setText(String.valueOf(nb1 / nb2));

    }






}
