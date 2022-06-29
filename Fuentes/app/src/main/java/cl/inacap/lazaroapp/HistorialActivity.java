package cl.inacap.lazaroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistorialActivity extends AppCompatActivity {

    TextView ej1Texto1;
    TextView ej1Texto2;
    TextView ej1Texto3;

    TextView ej2Texto1;
    TextView ej2Texto2;
    TextView ej2Texto3;

    Button verDetalles1;
    Button verDetalles2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        ej1Texto1=(TextView) findViewById(R.id.Ej1texto1);
        ej1Texto2=(TextView) findViewById(R.id.Ej1texto2);
        ej1Texto3=(TextView) findViewById(R.id.Ej1texto3);

        ej2Texto1=(TextView) findViewById(R.id.Ej2texto1);
        ej2Texto2=(TextView) findViewById(R.id.Ej2texto1);
        ej2Texto3=(TextView) findViewById(R.id.Ej2texto1);

        verDetalles1=(Button) findViewById(R.id.btnDetalle1);

        verDetalles2=(Button) findViewById(R.id.btnDetalle2);

        verDetalles1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CalificarActivity.class);
                intent.putExtra("id","1");
                intent.putExtra("ej1texto1",ej1Texto1.getText());
                intent.putExtra("ej1texto2",ej1Texto2.getText());
                intent.putExtra("ej1texto3",ej1Texto3.getText());
                startActivity(intent);
            }
        });

        verDetalles2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CalificarActivity.class);
                intent.putExtra("id","2");
                intent.putExtra("ej2texto1",ej2Texto1.getText());
                intent.putExtra("ej2texto2",ej2Texto2.getText());
                intent.putExtra("ej2texto3",ej2Texto3.getText());
                startActivity(intent);
            }
        });


    }
}