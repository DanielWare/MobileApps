package edu.uco.dware6.p4danielwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.signup_btn).setOnClickListener(v->{
            startActivity(new Intent(this, SignupActivity.class));
        });

        findViewById(R.id.dept_btn).setOnClickListener(v->{
            startActivity(new Intent(this, DepartmentActivity.class));
        });
    }
}
