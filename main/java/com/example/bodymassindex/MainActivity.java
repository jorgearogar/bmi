package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText w1 = (EditText) findViewById(R.id.w);
        final EditText h2 = (EditText) findViewById(R.id.h);
        final TextView r1 = (TextView) findViewById(R.id.r);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1 = w1.getText().toString();
                String str2 = h2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    w1.setError("Please enter your weight");
                    w1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    h2.setError("Please enter your height");
                    h2.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

                float bmiValue = calculateBMI(weight, height);


                String bmiInterpretation = interpretBMI(bmiValue);

                r1.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }


    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}