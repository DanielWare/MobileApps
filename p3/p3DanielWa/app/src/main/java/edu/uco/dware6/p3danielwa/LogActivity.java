package edu.uco.dware6.p3danielwa;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        try {
            int[] wins = getIntent().getIntArrayExtra(getString(R.string.WINSLIST));

            if (wins == null) {
                throw new NullPointerException("wins was not initialized");
            }
            if (wins.length < 1) {
                //array not passed -- error --
                throw new IndexOutOfBoundsException("wins array was not greater than 0");
            }
            TableLayout table = (TableLayout) findViewById(R.id.log_table);

            for (int i = 0; i < wins.length; i++) {
                //create new table row
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                //add gameNumber
                TextView gameNumber = new TextView(this);
                gameNumber.setText("" + (i + 1));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    gameNumber.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                row.addView(gameNumber);

                //add result
                TextView gameResult = new TextView(this);
                switch (wins[i]) {
                    case 0:
                        gameResult.setText(getString(R.string.draw));
                        break;
                    case 1:
                        gameResult.setText(getString(R.string.X_winner));
                        break;
                    case 2:
                        gameResult.setText(getString(R.string.O_winner));
                        break;
                    default:
                        // -- error --
                        break;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    gameResult.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                row.addView(gameResult);
                table.addView(row);
            }
        }
        catch (NullPointerException | IndexOutOfBoundsException ex){
            Toast noDataToast = new Toast(this).makeText(this, R.string.no_data, Toast.LENGTH_LONG);
            noDataToast.show();
        }


    }
}
