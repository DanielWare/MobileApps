package com.example.daniel.p2danielwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ComputeActivity extends Activity {

    private EditText mNum1EditText;
    private EditText mNum2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        Button addButton = (Button)findViewById(R.id.addButton);
        Button multiplyButton = (Button)findViewById(R.id.multiplyButton);

        Intent multiplyIntent = new Intent(ComputeActivity.this, MultiplyActivity.class);
        mNum1EditText = (EditText)findViewById(R.id.computeNum1EditView);
        mNum2EditText = (EditText)findViewById(R.id.computeNum2EditView);

        Context context = getApplicationContext();
        Toast invalidNumberToast = Toast.makeText(context, R.string.invalid_number, Toast.LENGTH_SHORT);

        addButton.setOnClickListener(v->{
            try{
                float num1 = Float.parseFloat(mNum1EditText.getText().toString());
                float num2 = Float.parseFloat(mNum2EditText.getText().toString());
                Intent addIntent = new Intent(ComputeActivity.this, AddActivity.class);
                addIntent.putExtra("NUM1", num1);
                addIntent.putExtra("NUM2", num2);
                startActivityForResult(addIntent, 0);
            }
            catch(NumberFormatException ex){
                //throw invalid number format toast
                invalidNumberToast.show();
            }
        });

        multiplyButton.setOnClickListener(v->{
            try{
                float num1 = Float.parseFloat(mNum1EditText.getText().toString());
                float num2 = Float.parseFloat(mNum2EditText.getText().toString());
                multiplyIntent.putExtra("NUM1", num1);
                multiplyIntent.putExtra("NUM2", num2);
                startActivityForResult(multiplyIntent, 0);
            }
            catch(NumberFormatException ex){
                //throw invalid number format toast
                invalidNumberToast.show();
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        mNum1EditText.setText("");
        mNum2EditText.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data == null || requestCode != 0){
            return;
        }
        //set result
        String result = data.getStringExtra("RESULT");

        TextView resultView = (TextView)findViewById(R.id.computeResultView);
        resultView.setText(result);
    }
}
