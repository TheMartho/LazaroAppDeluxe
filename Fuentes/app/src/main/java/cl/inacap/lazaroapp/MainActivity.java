package cl.inacap.lazaroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import cl.inacap.lazaroapp.dao.AdultoMayorDAO;
import cl.inacap.lazaroapp.dao.AdultoMayorDAOSQL;
import cl.inacap.lazaroapp.dao.BD;
import cl.inacap.lazaroapp.dto.AdultoMayor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.libraries.places.api.Places;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnElegirViaje;
    Button btnHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificarPermisos();

        btnHistorial = (Button) findViewById(R.id.btnHistorial);
        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HistorialActivity.class);
                startActivity(intent);
            }
        });

        btnElegirViaje = (Button) findViewById(R.id.btn_elegir_viaje);
        btnElegirViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SolicitarViajeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void verificarPermisos(){
        int permisoLocalizacion= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permisoLocalizacion == PackageManager.PERMISSION_GRANTED){

        }else{
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
    }


}