package com.example.tute2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton radioButton1;
    RadioButton radioButton2;
    Button b_calculate;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        textView = findViewById(R.id.textView);
        b_calculate = findViewById(R.id.b_calculate);
    }


    @Override
    protected void onResume() {
        super.onResume();

        b_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculation calculation = new Calculation();

        String temp_value = et_value.getText().toString();


        if (TextUtils.isEmpty(temp_value)) {
            Toast.makeText( this, "Please add a value", Toast.LENGTH_LONG).show();
            temp_value = "0.0";
            textView.setText(temp_value);
        } else {
            Float temp = Float.parseFloat(temp_value);

            if (radioButton1.isChecked()) {
                temp = calculation.convertCelciusToFahrenheit(temp);

            } else if (radioButton2.isChecked()) {
                temp = calculation.convertFahrenheitToCelcius(temp);

            } else {
                Toast.makeText(  this,  "Please add a value", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            textView.setText(new Float(temp).toString());
        }
    }


}