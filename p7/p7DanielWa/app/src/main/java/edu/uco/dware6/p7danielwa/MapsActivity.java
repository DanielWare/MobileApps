package edu.uco.dware6.p7danielwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends Activity implements OnMapReadyCallback {

    private GoogleMap map;

    private ContentType currentMapContent;

    ArrayList<Department> departmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        departmentList = new ArrayList<>();

        String[] deptName = getResources().getStringArray(R.array.deptNames);
        String[] deptPhones = getResources().getStringArray(R.array.deptPhones);
        String[] deptUrl = getResources().getStringArray(R.array.deptURLs);
        String[] deptlat = getResources().getStringArray(R.array.deptLatitudes);
        String[] deptlng = getResources().getStringArray(R.array.deptLongitudes);

        for(int i = 0; i < deptName.length; i++){
            String name = deptName[i];
            String number = deptPhones[i];
            String url = deptUrl[i];
            LatitudeLng ll = new LatitudeLng(deptlat[i], deptlng[i]);
            departmentList.add(new Department(name, number, url, ll));
        }

        try{
            currentMapContent = (ContentType)getIntent().getSerializableExtra("ContentType");
        }catch(Exception e){

        }
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        for(Department d:departmentList){
            LatLng coord = new LatLng(d.getLatLng().getLat(), d.getLatLng().getLng());
            map.addMarker(new MarkerOptions().position(coord).title(d.getName()));
        }


        //this was taken from http://stackoverflow.com/a/31852074
        //this allows us to show the temp and name when a marker is clicked
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                Context context = getApplicationContext();

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String title = marker.getTitle();
                Department selectedDepartment = null;
                for(Department d:departmentList){
                    if(d.getName().equalsIgnoreCase(title)){
                        selectedDepartment = d;
                        break;
                    }
                }

                if(selectedDepartment != null){
                    if(currentMapContent == ContentType.PHONE){
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + selectedDepartment.getPhoneNumber()));
                        startActivity(callIntent);
                    }else if(currentMapContent == ContentType.WEB){
                        Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedDepartment.getHomePage()));
                        startActivity(urlIntent);
                    }
                }

                return false;
            }
        });


        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.654108, -97.473186), 18f));

    }
}
