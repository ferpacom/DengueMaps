package com.example.ferpa.denguemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.ferpa.denguemaps.entities.PlaceEntity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private PlaceEntity place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //Recebe o objeto place da MainActivity
        place = (PlaceEntity) getIntent().getSerializableExtra("place");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker and move the camera
        LatLng latlng = new LatLng(place.getLat(), place.getLng());
        //os itens abaixo coloquei manualment, sem passar por parametro apenas para utilizar mais de um ponto no mapa. Apenas como exemplo.
        LatLng latlng2 = new LatLng(-25.428017,-49.311259);
        LatLng latlng3 = new LatLng(-25.420627, -49.312176);
        LatLng latlng4 = new LatLng(-25.407180, -49.304586);
        mMap.addMarker(new MarkerOptions().position(latlng).title("Foco Da Dengue1"));
        mMap.addMarker(new MarkerOptions().position(latlng2).title("Foco Da Dengue2"));
        mMap.addMarker(new MarkerOptions().position(latlng3).title("Foco Da Dengue3"));
        mMap.addMarker(new MarkerOptions().position(latlng4).title("Foco Da Dengue4"));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(place.getLat(), place.getLng()))      // Sets the center of the map to Mountain View
                .zoom(12)                   // Sets the zoom
                .tilt(85)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
