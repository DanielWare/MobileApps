package edu.uco.dware6.p4danielwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
<<<<<<< Updated upstream
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
=======
import android.view.View;
import android.widget.AdapterView;
>>>>>>> Stashed changes
import android.widget.ArrayAdapter;
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
        for (int i = 0; i < deptNames.length; i++) {
            mDepartments.add(
                    new Department(
                            deptNames[i].toString(),
                            deptNumbers[i].toString(),
                            deptURLs[i].toString()));
        }

<<<<<<< Updated upstream
        ListView lv = (ListView) findViewById(R.id.dept_list_view);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, R.layout.dept_item, deptNames);
=======
        ListView lv = (ListView)findViewById(R.id.dept_list_view);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.dept_item, deptNames);
>>>>>>> Stashed changes

        lv.setAdapter(adapter);
        lv.setLongClickable(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("long click " + i);


                //TODO show CAB and send mDepartments[i] phone and url // maybe name?


<<<<<<< Updated upstream
        lv.setOnItemLongClickListener((parent, view, position, id) -> {
=======
                return false;
            }
        });
>>>>>>> Stashed changes

            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private class ActionModeCallback implements ActionMode.Callback {

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_call:
                    Intent callIntent = new Intent();
                    callIntent.putExtra()
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.menu_url:

                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }

        // Called each time the action mode is shown.
        // Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // return false if nothing is done
        }
    }

}


}
