package cl.inacap.lazaroapp.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import cl.inacap.lazaroapp.dto.AdultoMayor;

public class AdultoMayorDAOSQL implements  AdultoMayorDAO{

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    public List<AdultoMayor> getAll() {
        return null;
    }

    @Override
    public AdultoMayor save(AdultoMayor am) {


        DatabaseReference myRef = database.getReference("Usuario/rut/apellidos");
        myRef.setValue("Alfaro");
        return null;
    }
}
