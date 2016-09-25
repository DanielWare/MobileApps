package edu.uco.dware6.p5danielwa;

import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DepartmentDialogFragment extends DialogFragment {

    private ArrayList<Department> departments;

    private static final int NOTIFICATION_ID = 1;


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        departments = new ArrayList<>();

        String[] deptNames = getResources().getStringArray(R.array.deptNames);
        String[] deptHomePages = getResources().getStringArray(R.array.deptURLs);
        for(int i = 0; i < deptNames.length; i++){
            departments.add(new Department(deptNames[i], deptHomePages[i]));
        }

        ListView lv = (ListView) getActivity().findViewById(R.id.dept_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dept_item, deptNames);
        lv.setAdapter(adapter);
        lv.setClickable(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent homepageIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(departments.get(position).getHomePage()));

                Notification.Builder builder = new Notification.Builder(getActivity())
                        .setSmallIcon(android.R.drawable.stat_notify_voicemail)
                        .setAutoCancel(true)
                        .setContentTitle(departments.get(position).getName())
                        .setContentIntent(PendingIntent.getActivity(getActivity(), 0, homepageIntent, PendingIntent.FLAG_UPDATE_CURRENT));

                NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, builder.build());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_department_dialog, container, false);
    }



}
