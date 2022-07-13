package cl.inacap.lazaroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarViajeActivity extends AppCompatActivity {

    TextView tvOrigenADestino;
    Button confirmar;
    Button cancelar;
    Button lazaroFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_viaje);
        tvOrigenADestino = (TextView) findViewById(R.id.origenADestino);
        String origen = getIntent().getStringExtra("Origen");
        String destino = getIntent().getStringExtra("Destino");
        tvOrigenADestino.setText("¿Desea solicitar un viaje desde  " + origen + "hacia  "+ destino+"?");




        confirmar = (Button) findViewById(R.id.btnConfirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HistorialActivity.class);
                startActivity(intent);
            }
        });

        lazaroFavorito = (Button) findViewById(R.id.lazaro_favorito);

        try{
            String favorito = getIntent().getStringExtra("favorito");
            if(favorito.isEmpty()){
                lazaroFavorito.setText("Priorizando viajar con "+favorito);
            }

        }catch (Exception ex){

        }

        lazaroFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LazaroFavoritoActivity.class);
                intent.putExtra("Origen",origen);
                intent.putExtra("Destino",destino);
                startActivity(intent);
            }
        });

        cancelar = (Button) findViewById(R.id.btnCancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}