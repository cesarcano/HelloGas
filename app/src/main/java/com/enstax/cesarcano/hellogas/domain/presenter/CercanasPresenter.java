package com.enstax.cesarcano.hellogas.domain.presenter;

import android.database.Cursor;

import com.enstax.cesarcano.hellogas.data.local.GasolinerasTableTransaction;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.CercanasContract;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.CercanasFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class CercanasPresenter implements CercanasContract.Presenter {
    private FirebaseAuth.AuthStateListener authStateListener;
    private CercanasContract.View cercanasView;

    public CercanasPresenter(CercanasFragment cercanasFragment) {
        this.cercanasView = cercanasFragment;
    }

    @Override
    public void attachView(CercanasContract.View view) {
        this.cercanasView = view;
    }

    @Override
    public void detachView() {
        this.cercanasView = null;
    }

    @Override
    public void loadByDistance() {

    }

    @Override
    public void loadByPromo() {

    }

    @Override
    public void loadByValoration() {

    }

    @Override
    public void loadByPrice() {
        cercanasView.loading();
        ArrayList<Gasolinera> gasolineras = new ArrayList<>();
        GasolinerasTableTransaction db = new GasolinerasTableTransaction(cercanasView.getContext());
        Cursor g = db.getGasolinerasByPrecio();

        cercanasView.loadList(gasolineras);
    }
}