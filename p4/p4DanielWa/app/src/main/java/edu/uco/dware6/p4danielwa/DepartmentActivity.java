package edu.uco.dware6.p4danielwa;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.widget.ListView;

import java.util.ArrayList;

public class DepartmentActivity extends Activity {

    private ActionMode actionMode;
    private ArrayList<Department> mDepartments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        mDepartments = new ArrayList<>();

        CharSequence[] deptNames = getResources().getTextArray(R.array.deptNames);
        CharSequence[] deptNumbers = getResources().getTextArray(R.array.deptPhones);
        CharSequence[] deptURLs = getResources().getTextArray(R.array.deptURLs);
        for(int i = 0; i < deptNames.length; i++){
            mDepartments.add(
                    new Department(
                            deptNames[i].toString(),
                            deptNumbers[i].toString(),
                            deptURLs[i].toString()));
        }

        ListView lv = (ListView)findViewById(R.id.dept_list_view);
        String[] s = new String[] {"a", "b", "c", "d"};

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.department_item, s);*/

        DepartmentAdapter adapter = new DepartmentAdapter(this, mDepartments);
        lv.setAdapter(adapter);

        //lv.setAdapter(adapter);

    }


}
