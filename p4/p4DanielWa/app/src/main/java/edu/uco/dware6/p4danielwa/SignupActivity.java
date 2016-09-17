package edu.uco.dware6.p4danielwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Date;

public class SignupActivity extends Activity {

    private int mClassificationIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //dob button
        DatePickerFragment dateFragment = new DatePickerFragment();
        findViewById(R.id.date_picker_btn).setOnClickListener(v->{
            dateFragment.show(getFragmentManager(), "date_picker");
        });

        //class spinner
        Spinner classificationSpinner = (Spinner)findViewById(R.id.classification_spinner);

        classificationSpinner.setAdapter(ArrayAdapter.createFromResource(this,
                R.array.array_classification, R.layout.spinner_item));

        classificationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mClassificationIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //gender radio buttons
        RadioGroup genderRadioGroup = (RadioGroup)findViewById(R.id.gender_radio_group);

        //skills checkboxes
        CheckBox skill1 = (CheckBox)findViewById(R.id.skill1);
        CheckBox skill2 = (CheckBox)findViewById(R.id.skill2);
        CheckBox skill3 = (CheckBox)findViewById(R.id.skill3);
        CheckBox skill4 = (CheckBox)findViewById(R.id.skill4);
        CheckBox skill5 = (CheckBox)findViewById(R.id.skill5);


        //register button
        findViewById(R.id.register_btn).setOnClickListener(v->{
            String name = ((EditText)findViewById(R.id.full_name_edit)).getText().toString();
            String pass = ((EditText)findViewById(R.id.password_edit)).getText().toString();
            Date dob = new Date(dateFragment.getYear(), dateFragment.getMonth(), dateFragment.getDay());
            GenderEnum gender = GenderEnum.values()[genderRadioGroup.getCheckedRadioButtonId() - 1];
            ClassificationEnum classification = ClassificationEnum.values()[mClassificationIndex];
            Boolean[] skills = new Boolean[getResources().getTextArray(R.array.array_classification).length];
            skills[0] = skill1.isChecked();
            skills[1] = skill2.isChecked();
            skills[2] = skill3.isChecked();
            skills[3] = skill4.isChecked();
            skills[4] = skill5.isChecked();
            User u = new User(name, pass, dob, gender, classification, skills);

            Intent registerIntent = new Intent(this, RegisterActivity.class);
            registerIntent.putExtra("USER", u);
            startActivity(registerIntent);
        });

    }
}
