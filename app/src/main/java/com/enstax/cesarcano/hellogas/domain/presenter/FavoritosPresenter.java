package com.enstax.cesarcano.hellogas.domain.presenter;

import android.app.Fragment;

import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosContract;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by cesarcanojmz@gmail.com
 */
public class FavoritosPresenter implements FavoritosContract.Presenter {

    private Fragment context;
    private FavoritosContract.View favoritosView;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    public FavoritosPresenter(FirebaseAuth auth, Fragment context) {
        this.context = context;
        this.auth = auth;
    }

    @Override
    public void attachView(FavoritosContract.View view) {
        this.favoritosView = view;
    }

    @Override
    public void detachView() {
        this.favoritosView = null;
    }

    @Override
    public void loadFavoritos() {

    }

    @Override
    public void getCurrentUser() {
        if (auth.getCurrentUser() != null)
            favoritosView.setUser(auth.getCurrentUser());
    }

    @Override
    public void deleteFavorito() {

    }
}