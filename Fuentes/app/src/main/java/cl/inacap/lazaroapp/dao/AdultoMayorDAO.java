package cl.inacap.lazaroapp.dao;

import java.util.List;

import cl.inacap.lazaroapp.dto.AdultoMayor;

public interface AdultoMayorDAO {
    List<AdultoMayor> getAll();
    AdultoMayor save (AdultoMayor am);
}
