package com.enstax.cesarcano.hellogas.data.firebase;

import com.enstax.cesarcano.hellogas.data.firebase.model.Gasolinera;
import com.enstax.cesarcano.hellogas.data.firebase.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class HgFirebaseDB {

    private DatabaseReference mDatabase;

    public HgFirebaseDB() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void createUser(String userId, String nombre, String email) {
        User user = new User(nombre, email);
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void createGasStation(String id, String marca, String direccion, Double latitud, Double longitud) {
        Gasolinera gasolinera = new Gasolinera(marca, direccion, latitud, longitud);
        mDatabase.child("gasolineras").child(id).setValue(gasolinera);
    }
}