package cl.inacap.lazaroapp.dao;

import java.util.List;

public interface FavoritosDAO {
    List<Favorito> getAll();
    Favorito save(Favorito f);
}
