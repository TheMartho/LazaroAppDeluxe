package cl.inacap.lazaroapp.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BD {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void si() {
        DatabaseReference myRef = database.getReference("Usuario/rut/apellidos");
        myRef.setValue("alfaro");
    }

}
