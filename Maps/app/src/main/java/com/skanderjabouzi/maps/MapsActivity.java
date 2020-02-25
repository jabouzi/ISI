package com.skanderjabouzi.maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_LOCATION = 1;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setupLocationClient();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
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
        getCurrentLocation();
        mMap = googleMap;

        mMap.setOnCameraMoveListener(
                new GoogleMap.OnCameraMoveListener() {
                    @Override
                    public void onCameraMove() {
                        CameraPosition position = mMap.getCameraPosition();
                        Log.e("ZOOM", String.valueOf(position.zoom));
                    }
                }
        );

        // Add a marker in Sydney and move the camera
        LatLng montreal = new LatLng(45.508888, -73.561668);
        LatLng laval = new LatLng(45.612499, -73.707092);
        LatLng longueuil = new LatLng(45.536945, -73.510712);
        LatLng toronto = new LatLng(43.651070, -79.347015);
        LatLng ottawa = new LatLng(45.424721, -75.695000);
        mMap.addMarker(new MarkerOptions().position(montreal).title("Marker in Montreal"));
        mMap.addMarker(new MarkerOptions().position(laval).title("Marker in Laval"));
        mMap.addMarker(new MarkerOptions().position(longueuil).title("Marker in Longueuil"));
        mMap.addMarker(new MarkerOptions().position(toronto).title("Marker in Toronto"));
        mMap.addMarker(new MarkerOptions().position(ottawa).title("Marker in Ottawa"));

        mMap.setMinZoomPreference(3);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Log.e("Maps", "Location permission denied");
            }
        }
    }

    private void setupLocationClient() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    private void requestLocationPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermissions();
        } else {
            fusedLocationClient.getLastLocation().addOnCompleteListener(
                    new OnCompleteListener<Location>() {
                        @Override
                        public void onComplete(@NonNull Task<Location> task) {
                            if (task.getResult() != null) {
                                LatLng latLng = new LatLng(task.getResult().getLatitude(), task.getResult().getLongitude());
                                Log.e("Maps1", latLng.toString());
                                mMap.addMarker(new MarkerOptions().position(latLng).title("My Position"));
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                            } else {
                                Log.e("Maps0", "No location found");
                            }
                        }
                    }
            );
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.dialog_layout, null);
        final EditText title = view.findViewById(R.id.title);
        final EditText latitude = view.findViewById(R.id.latitude);
        final EditText longitude = view.findViewById(R.id.longitude);
        builder.setView(view);
        builder.setTitle("Add city");
        builder.setMessage("Add City Information");
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                LatLng latLng = new LatLng(Float.parseFloat(latitude.getText().toString()), Float.parseFloat(longitude.getText().toString()));
                Log.e("Maps2", latLng.toString());
                mMap.addMarker(new MarkerOptions().position(latLng).title(title.getText().toString()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });

        builder.show();
    }
}
