package edu.uco.dware6.p6danielwa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class MapsActivity extends Activity implements OnMapReadyCallback{

    private GoogleMap map;

    private City currentCity;

    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        currentCity = null;
        currentCity = (City)getIntent().getSerializableExtra("City");

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng cityCoord = new LatLng(currentCity.getLatitudeLng().getLat(),
                currentCity.getLatitudeLng().getLng());
        marker = map.addMarker(new MarkerOptions().position(cityCoord).title(currentCity.getName())
                .snippet(String.valueOf(currentCity.getTemp() + " F")));

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

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(cityCoord, 13f));


    }


}
