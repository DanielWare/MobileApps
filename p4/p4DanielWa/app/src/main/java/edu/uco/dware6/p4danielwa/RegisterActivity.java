package edu.uco.dware6.p4danielwa;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        User u = (User)getIntent().getSerializableExtra("USER");
        LinearLayout registerLayout = (LinearLayout)findViewById(R.id.register_layout);
        TextView tv = CreateHeaderRow("Full Name");
        registerLayout.addView(tv);
        tv = CreateItemRow(u.getFullName());
        registerLayout.addView(tv);
        tv = CreateHeaderRow("Password");
        registerLayout.addView(tv);
        tv = CreateItemRow(u.getPassword());
        registerLayout.addView(tv);
        tv = CreateHeaderRow("Date of Birth");
        registerLayout.addView(tv);
        Date d = u.getDateOfBirth();
        tv = CreateItemRow("" + d.getMonth() + "/" + d.getDay() + "/" + d.getYear());
        registerLayout.addView(tv);
        tv = CreateHeaderRow("Gender");
        registerLayout.addView(tv);
        tv = CreateItemRow(u.getGender().toString());
        registerLayout.addView(tv);
        tv = CreateHeaderRow("Classification");
        registerLayout.addView(tv);
        tv = CreateItemRow(u.getClassification().toString());
        registerLayout.addView(tv);
        tv = CreateHeaderRow("Skills");
        registerLayout.addView(tv);
        Boolean[] s = u.getSkills();
        CharSequence[] skills = getResources().getTextArray(R.array.skills);
        for(int i = 0; i < skills.length; i++){
            if(s[i]){
                tv = CreateItemRow(skills[i].toString());
                registerLayout.addView(tv);
            }
        }
    }


    private TextView CreateHeaderRow(String s){
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setBackgroundColor(getResources().getColor(R.color.darkGray));
        tv.setTextSize(getResources().getDimension(R.dimen.header_text_size));
        tv.setText(s);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        return tv;
    }

    private TextView CreateItemRow(String s){
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setBackgroundColor(getResources().getColor(R.color.lightGray));
        tv.setTextSize(getResources().getDimension(R.dimen.item_text_size));
        tv.setText(s);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        return tv;
    }

}
