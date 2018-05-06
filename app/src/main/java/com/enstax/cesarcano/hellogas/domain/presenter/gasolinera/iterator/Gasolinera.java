package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.iterator;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface Gasolinera {
    interface Get {
        void getInfo(String id);
    }

    interface SetFavorito {
        void setFavorito(String gid);
    }

    interface Iterator {
        void load(com.enstax.cesarcano.hellogas.domain.model.Gasolinera gasolinera);
        void favorite(Boolean b);
    }

}
