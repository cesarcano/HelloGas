package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator;

import android.content.Context;

import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.GasolineraPresenter;

import org.json.JSONObject;

/**
 * Created by cesar on 29/04/18.
 */

public class GetDetalleGas implements WebTask.Presenter, Gasolinera.Get  {


    private Context context;
    private Gasolinera.Iterator presenter;

    public GetDetalleGas(Context context, GasolineraPresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    public GetDetalleGas(Context context, GasolineraPresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void response(JSONObject jsonObject) {

    }

    @Override
    public void getInfo(String id) {

    }
}
