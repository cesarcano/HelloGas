package com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators;

import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.FavoritosPresenter;

import org.json.JSONObject;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SetFavoritos implements Favoritos.Set, WebTask.Presenter{

    private Favoritos.Iterator presenter;

    public SetFavoritos(FavoritosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void add(String id) {
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public void response(JSONObject jsonObject) {

    }
}
