package cl.inacap.lazaroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.lazaroapp.adapters.FavoritosArrayAdapter;
import cl.inacap.lazaroapp.dao.Favorito;
import cl.inacap.lazaroapp.dao.FavoritosDAO;
import cl.inacap.lazaroapp.dao.FavoritosDAOLista;

public class LazaroFavoritoActivity extends AppCompatActivity {
    private ListView favoritosLv;
    private List<Favorito> favoritos;
    private FavoritosArrayAdapter adaptador;
    private FavoritosDAO favoritosDAO = FavoritosDAOLista.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazaro_favorito);

        String origen = getIntent().getStringExtra("Origen");
        String destino = getIntent().getStringExtra("Destino");
        favoritos = favoritosDAO.getAll();
        adaptador = new FavoritosArrayAdapter(this,R.layout.favoritos_list,favoritos);
        favoritosLv=findViewById(R.id.lazaro_lv);
        favoritosLv.setAdapter(adaptador);
        favoritosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LazaroFavoritoActivity.this, ConfirmarViajeActivity.class);
                Favorito favoritoActual = favoritos.get(i);
                intent.putExtra("favorito",favoritoActual.getNombre());
                intent.putExtra("Origen",origen);
                intent.putExtra("Destino",destino);
                startActivity(intent);
            }
        });
    }
}