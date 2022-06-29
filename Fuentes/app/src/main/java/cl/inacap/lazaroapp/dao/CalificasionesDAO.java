package cl.inacap.lazaroapp.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.lazaroapp.dto.Calificasion;


public class CalificasionesDAO {

    private List<Calificasion> calificasiones = new ArrayList<>();

    private CalificasionesDAO(){
        Calificasion c = new Calificasion();
        c.setId(1);
        c.setDescripcion("1");
        c.setCantidadeEstrellas(0);
        calificasiones.add(c);

        c.setId(2);
        c.setDescripcion("2");
        c.setCantidadeEstrellas(0);
        calificasiones.add(c);

    }

    public Calificasion save(Calificasion c) {
        calificasiones.add(c);
        return c;
    }

    public  List<Calificasion> getAll(){
        return calificasiones;
    }

}
