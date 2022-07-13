package cl.inacap.lazaroapp.adapters;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

import cl.inacap.lazaroapp.ConfirmarViajeActivity;
import cl.inacap.lazaroapp.LazaroFavoritoActivity;
import cl.inacap.lazaroapp.dao.Favorito;
import cl.inacap.lazaroapp.R;

public class FavoritosArrayAdapter extends ArrayAdapter<Favorito> {
   private Activity activity;
   private List<Favorito> favoritos;
   public  FavoritosArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Favorito> objects){
       super(context, resource, objects);
       this.activity=context;
       this.favoritos=objects;
   }

   @NonNull
   @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
       LayoutInflater inflater = this.activity.getLayoutInflater();
       View fila = inflater.inflate(R.layout.favoritos_list,null,true);
       //Componentes como textview y cosas asi
       Favorito actual = favoritos.get(position);
       TextView nombreTv = fila.findViewById(R.id.favorito_lv);
       nombreTv.setText(actual.getNombre());

       return fila;
   }
}
