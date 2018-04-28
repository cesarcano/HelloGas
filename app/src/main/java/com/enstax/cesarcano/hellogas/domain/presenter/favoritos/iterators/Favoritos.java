package com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */


public interface Favoritos {
    interface Set {
        void add(String id);
        void delete(String id);
    }

    interface Get {
        void getAll();
    }

    interface Iterator {
        void load(ArrayList<Gasolinera> gasolineras);
    }
}
