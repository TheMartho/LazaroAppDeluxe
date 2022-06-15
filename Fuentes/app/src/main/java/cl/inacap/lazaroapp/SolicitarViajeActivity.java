package cl.inacap.lazaroapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class SolicitarViajeActivity extends AppCompatActivity {

    private static int ORIGEN_REQUEST_CODE = 1;
    private static int DESTINO_REQUEST_CODE = 2;
    Button btnOrigen;
    Button btnDestino;
    TextView tvOrigen;
    TextView tvDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_viaje);
        Places.initialize(getApplicationContext(),getString(R.string.android_sdk_places_api_key));
        tvDestino = (TextView) findViewById(R.id.tvDestino);
        tvOrigen = (TextView) findViewById(R.id.tvOrigen);
        btnOrigen = (Button) findViewById(R.id.btnOrigen);
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
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

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

            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage().toString());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            } else if (requestCode == DESTINO_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    Place place = Autocomplete.getPlaceFromIntent(data);
                    Log.i(TAG, "Place: Name y ID" + place.getName() + ", " + place.getId() + ", " + place.getLatLng()+ ", " + place.getAddress());

                    tvDestino.setText("Direccion Destino: " + place.getName());

                    return;
                }
                super.onActivityResult(requestCode, resultCode, data);
            }

        }
    }
}