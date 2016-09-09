package com.example.daniel.p2danielwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        float num1 = getIntent().getFloatExtra("NUM1", -999);
        float num2 = getIntent().getFloatExtra("NUM2", -999);

        String result = "" + (num1 + num2);

        TextView num1TextView = (TextView)findViewById(R.id.addNum1EditView);
        num1TextView.setText("" + num1);
        TextView num2TextView = (TextView)findViewById(R.id.addNum2EditView);
        num2TextView.setText("" + num2);
        TextView resultView = (TextView)findViewById(R.id.addResultView);

        Button addButton = (Button)findViewById(R.id.addAddButton);

        addButton.setOnClickListener(v->{
            resultView.setText(result);
            Intent data = new Intent();
            data.putExtra("RESULT", result);
            setResult(RESULT_OK, data);
        });

    }
}
