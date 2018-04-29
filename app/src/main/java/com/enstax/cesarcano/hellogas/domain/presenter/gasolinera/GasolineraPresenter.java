package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera;

import android.content.Context;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle.DetalleGasContract;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle.DetalleGasolinera;

/**
 * Created by cesar on 29/04/18.
 */

public class GasolineraPresenter implements DetalleGasContract.Presenter, com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.Gasolinera.Iterator {
    private DetalleGasContract.View view;
    private Context context;

    public GasolineraPresenter(DetalleGasolinera view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void attachView(DetalleGasContract.View view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void getInfo(String id) {

    }

    @Override
    public void setFavorite() {

    }

    @Override
    public void setInfo(Gasolinera gasolinera) {

    }

    @Override
    public void load(com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.Gasolinera gasolinera) {

    }
}
