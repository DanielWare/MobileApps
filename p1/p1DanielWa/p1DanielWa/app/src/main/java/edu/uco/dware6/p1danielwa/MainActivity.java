package edu.uco.dware6.p1danielwa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final String nameText = "Daniel Ware";
    private final String degreeText = "Applied Math and Computer Science";
    private final String clearText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView displayView = (TextView)findViewById(R.id.textDisplay);
        Button nameButton = (Button)findViewById(R.id.nameButton);
        Button degreeButton = (Button)findViewById(R.id.degreeButton);
        Button clearButton = (Button)findViewById(R.id.clearButton);

        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView.setText(nameText);
            }
        });

        degreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView.setText(degreeText);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayView.setText(clearText);
            }
        });

    }
}
