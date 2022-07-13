package cl.inacap.lazaroapp.dao;

import java.util.ArrayList;
import java.util.List;

public class FavoritosDAOLista implements  FavoritosDAO{
    private  List<Favorito> favoritos = new ArrayList<>();
    private static  FavoritosDAOLista instancia;
    private FavoritosDAOLista(){

    }
    public  static  FavoritosDAOLista getInstance(){
        if(instancia==null){
            instancia=new FavoritosDAOLista();
        }
        return instancia;
    }


    @Override
    public List<Favorito> getAll() {
        return favoritos;
    }

    @Override
    public Favorito save(Favorito f) {
        favoritos.add(f);
        return f;
    }
}
