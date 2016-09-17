package edu.uco.dware6.p4danielwa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener{

    private int mYear = 1988;
    //month is 0 indexed for some reason? wtf??!
    private int mMonth = 8;
    private int mDay = 28;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, mYear, mMonth, mDay);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mYear = year;
        mDay = dayOfMonth;
        mMonth= month;
        ((Button)getActivity().findViewById(R.id.date_picker_btn))
                .setText("" + getMonth() + "/" + getDay()+"/" + getYear());
    }


    public int getYear() {
        return mYear;
    }

    public int getMonth() {
        //month is 0 indexed for some stupid reason
        //so add 1 to the month to get actual month
        return mMonth + 1;
    }

    public int getDay() {
        return mDay;
    }
}
