package com.enstax.cesarcano.hellogas.ui.view.favoritos;

import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface FavoritosContract {
    interface View extends BaseView {
        void loadList();
        void setUser(FirebaseUser user);
    }

    interface Presenter extends BasePresenter<FavoritosContract.View> {
        void loadFavoritos();
        void getCurrentUser();
        void deleteFavorito();
    }
}