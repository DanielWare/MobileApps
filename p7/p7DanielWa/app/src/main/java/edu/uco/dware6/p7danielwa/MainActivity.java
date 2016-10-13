package edu.uco.dware6.p7danielwa;

import android.annotation.TargetApi;
import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends Activity {

    Handler clockHandler;
    TextView timeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clockHandler = new Handler();
        timeView = (TextView)findViewById(R.id.time_view);
        Runnable updateClockTask = new Runnable() {
            @Override
            public void run() {
                setTime();
                clockHandler.postDelayed(this, 1000);
            }
        };
        updateClockTask.run();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        timeView.setText(dateFormat.format(new java.util.Date()));
    }
}
