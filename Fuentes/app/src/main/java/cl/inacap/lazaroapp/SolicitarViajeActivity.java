package cl.inacap.lazaroapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class SolicitarViajeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static int ORIGEN_REQUEST_CODE = 1;
    private static int DESTINO_REQUEST_CODE = 2;
    Button btnOrigen;
    Button btnDestino;
    TextView tvOrigen;
    TextView tvDestino;
    private GoogleMap mMap;
    private LatLng mOrigen;
    private  LatLng mDestino;
    private Marker mMarkerOrigen=null;
    private Marker mMarkerDestino=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_viaje);
        Places.initialize(getApplicationContext(),getString(R.string.android_sdk_places_api_key));
        tvDestino = (TextView) findViewById(R.id.tvDestino);
        tvOrigen = (TextView) findViewById(R.id.tvOrigen);
        btnOrigen = (Button) findViewById(R.id.btnOrigen);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        btnOrigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autocompleteOrigen();
            }
        });


        btnDestino = (Button) findViewById(R.id.btnDestino);
        btnDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autocompleteDestino();
            }
        });
        }


    public void autocompleteOrigen(){
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields)
                .build(this);
        startActivityForResult(intent, ORIGEN_REQUEST_CODE);
    }

    public void autocompleteDestino(){
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, DESTINO_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ORIGEN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: Name y ID" + place.getName() + ", " + place.getId() + ", " + place.getLatLng() + ", " + place.getAddress());

                tvOrigen.setText("Direccion Origen: " + place.getName());
                mOrigen=place.getLatLng();
                añadirMarcador(mOrigen, "Origen");


            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage().toString());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
                super.onActivityResult(requestCode, resultCode, data);

            }else if (requestCode == DESTINO_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: Name y ID" + place.getName() + ", " + place.getId() + ", " + place.getLatLng()+ ", " + place.getAddress());

                tvDestino.setText("Direccion Destino: " + place.getName());
                mDestino= place.getLatLng();
                añadirMarcador(mDestino,"Destino");

            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage().toString());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(15f);
        mMap.setMaxZoomPreference(20f);
        LatLng defecto = new LatLng(-33.049188, -71.612766);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defecto));

    }

    private void añadirMarcador(LatLng latLng, String title){
        if (title.equals("Origen")){
            if (mMarkerOrigen!=null){
                mMarkerOrigen.remove();
            }
            mMarkerOrigen=mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(title));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        }else if (title.equals("Destino")){
            if (mMarkerDestino!=null){
                mMarkerDestino.remove();
            }
            mMarkerDestino=mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(title));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        }


    }

}