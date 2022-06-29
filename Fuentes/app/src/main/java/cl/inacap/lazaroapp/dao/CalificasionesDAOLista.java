package cl.inacap.lazaroapp.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.lazaroapp.dto.Calificasion;

public class CalificasionesDAOLista implements  cDAO{

    private List<Calificasion> calificasions = new ArrayList<>();
    private  static CalificasionesDAOLista instancia;

    private  CalificasionesDAOLista(){
        Calificasion c = new Calificasion();
        c.setId(1);
        c.setDescripcion("1");
        c.setCantidadeEstrellas(0);
        calificasions.add(c);

        c.setId(2);
        c.setDescripcion("2");
        c.setCantidadeEstrellas(0);
        calificasions.add(c);

    }

    public  static CalificasionesDAOLista getInstance(){
        if(instancia==null){
            instancia=new CalificasionesDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Calificasion> getAll() {
        return calificasions;
    }

    @Override
    public Calificasion save(Calificasion c) {
        calificasions.add(c);
        return c;
    }
}
