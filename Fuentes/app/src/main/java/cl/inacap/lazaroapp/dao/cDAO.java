package cl.inacap.lazaroapp.dao;

import java.util.List;

import cl.inacap.lazaroapp.dto.Calificasion;

public interface cDAO {
    List<Calificasion> getAll();
    Calificasion save(Calificasion c);
}
