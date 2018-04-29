package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator;

/**
 * Created by cesar on 29/04/18.
 */

public interface Gasolinera {
    interface Get {
        void getInfo(String id);
    }

    interface Iterator {
        void load(Gasolinera gasolinera);
    }
}
