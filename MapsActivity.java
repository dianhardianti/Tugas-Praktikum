package com.sitihardiyanti.maps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
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

        // Add a marker in Sydney and move the camera
        LatLng kosdian = new LatLng(-0.8870392861077839, 119.87888486335285);
        mMap.addMarker(new MarkerOptions().position(kosdian).title("mark kos dian"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kosdian));
        LatLng stimik = new LatLng(-0.8866506,119.8752671);
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark stimik"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stimik));

        //custom size marker
        int tinggi = 120;
        int lebar = 120;
        BitmapDrawable bitmapstart = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_standard_color_18);
        BitmapDrawable bitmapdes = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_disabled_color_18);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapdes.getBitmap();
        Bitmap markstart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markdes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(kosdian).title("mark kos dian")
                .snippet("ini kosku")
                .icon(BitmapDescriptorFactory.fromBitmap(markstart)));
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark kampus")
                .snippet("ini stimik")
                .icon(BitmapDescriptorFactory.fromBitmap(markdes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stimik, 16));

        mMap.addPolyline(new PolylineOptions().add(
                kosdian,
                new LatLng(-0.888660334720347, 119.87868817214427),
                new LatLng(-0.88843505304418, 119.87767965255723),
                new LatLng(-0.8881454078668304, 119.8769125378421),
                new LatLng(-0.8877806707960478, 119.87524420257874),
                new LatLng(-0.8867669170199441, 119.87541049983383),
                stimik).width(12).color(Color.BLUE));

    }
}