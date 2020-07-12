package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculatorActivity extends AppCompatActivity {

    private EditText number1, number2;
    Button plus, min, mul, div;
    TextView result;
    int asidasio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);



        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        plus = findViewById(R.id.plus);
        min = findViewById(R.id.min);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString().trim());
                double num2 = Double.parseDouble(number2.getText().toString().trim());
                double res = num1 + num2;
                result.setText(num1
                        + " + "
                        + num2
                        + " = "
                        + res + "");
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString().trim());
                double num2 = Double.parseDouble(number2.getText().toString().trim());

                double res = num1 - num2;
                result.setText(num1
                        + " - "
                        + num2
                        + " = "
                        + res + "");
            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString().trim());
                double num2 = Double.parseDouble(number2.getText().toString().trim());

                double res = num1 * num2;
                result.setText(num1
                        + " * "
                        + num2
                        + " = "
                        + res + "");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString().trim());
                double num2 = Double.parseDouble(number2.getText().toString().trim());

                double res = num1 / num2;
                result.setText(num1
                        + " / "
                        + num2
                        + " = "
                        + res + "");
            }
        });

    }


}
