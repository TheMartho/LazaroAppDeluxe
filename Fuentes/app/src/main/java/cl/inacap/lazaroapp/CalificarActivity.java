package cl.inacap.lazaroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.inacap.lazaroapp.dao.CalificasionesDAO;
import cl.inacap.lazaroapp.dao.CalificasionesDAOLista;
import cl.inacap.lazaroapp.dao.cDAO;
import cl.inacap.lazaroapp.dto.Calificasion;

public class CalificarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnVolver;
    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private List<Calificasion> calificasiones;
    private cDAO cDAO = CalificasionesDAOLista.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);
        calificasiones = cDAO.getAll();
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        String id = getIntent().getStringExtra("id");
        texto1=(TextView) findViewById(R.id.texto1);
        texto2=(TextView) findViewById(R.id.texto2);
        texto3=(TextView) findViewById(R.id.texto3);
        if(getIntent()!=null){

            if(id.equals("1")){
                String ej1Texto1 = getIntent().getStringExtra("ej1texto1");
                String ej1Texto2 = getIntent().getStringExtra("ej1texto2");
                String ej1Texto3 = getIntent().getStringExtra("ej1texto3");
                ratingBar.setRating(calificasiones.get(0).getCantidadeEstrellas());
                texto1.setText(ej1Texto1 + "Con" + ej1Texto2);
                texto3.setText(ej1Texto3);

            }else{
                String ej2Texto1 = getIntent().getStringExtra("ej2texto1");
                String ej2Texto2 = getIntent().getStringExtra("ej2texto2");
                String ej2Texto3 = getIntent().getStringExtra("ej2texto3");
                ratingBar.setRating(calificasiones.get(1).getCantidadeEstrellas());
                texto2.setText("Conductor: Fernando Mercedez");
                texto1.setText(ej2Texto1 + "Con" + ej2Texto2);
                texto3.setText(ej2Texto3);
            }


        }



        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HistorialActivity.class);
                startActivity(intent);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(CalificarActivity.this, "Su Calificasión a sido guardada",Toast.LENGTH_LONG).show();
                ratingBar.setRating(v);
                if(id.equals("1")){
                    calificasiones.get(0).setCantidadeEstrellas(v);
                }else{
                    calificasiones.get(1).setCantidadeEstrellas(v);
                }
            }
        });
    }
}