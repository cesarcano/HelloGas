package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera;

import android.content.Context;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.GetDetalleGas;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.SetFavorito;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle.DetalleGasContract;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle.DetalleGasolinera;

/**
 * Created by cesar on 29/04/18.
 */

public class GasolineraPresenter implements DetalleGasContract.Presenter, com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.Gasolinera.Iterator {
    private DetalleGasContract.View view;
    private Context context;
    private com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.Gasolinera.Get get;
    private com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator.Gasolinera.SetFavorito setFavorito;

    public GasolineraPresenter(DetalleGasolinera view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void attachView(DetalleGasContract.View view) {
        view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getInfo(String id) {
        view.loading();
        get = new GetDetalleGas(context, this);
        get.getInfo(id);
    }

    @Override
    public void setFavorite(String gid) {
        view.loading();
        setFavorito = new SetFavorito(context, this);
        setFavorito.setFavorito(gid);
    }

    @Override
    public void load(Gasolinera gasolinera) {
        view.loadInfo(gasolinera);
    }

    @Override
    public void favorite(Boolean b) {
        view.heart(b);
    }
}
