package edu.uco.dware6.p4danielwa;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DepartmentAdapter extends ArrayAdapter<Department> {

    private Context context;
    private List<Department> depts;

    public DepartmentAdapter(Context context, List<Department> depts) {
        super(context, -1, depts);
        this.context = context;
        this.depts = depts;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dept_item, parent, false);

        TextView deptName = (TextView) rowView.findViewById(R.id.dept_name);
        TextView deptNumber = (TextView) rowView.findViewById(R.id.dept_number);
        TextView deptUrl = (TextView) rowView.findViewById(R.id.dept_url);

        deptName.setText(depts.get(pos).getName());
        deptNumber.setText(depts.get(pos).getPhoneNumber());
        deptUrl.setText(depts.get(pos).getHomePage());

        return rowView;
    }


}
