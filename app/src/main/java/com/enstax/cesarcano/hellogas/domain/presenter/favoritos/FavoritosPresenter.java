package com.enstax.cesarcano.hellogas.domain.presenter.favoritos;

import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosContract;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by cesarcanojmz@gmail.com
 */
public class FavoritosPresenter implements FavoritosContract.Presenter, WebTask.Presenter {

    private FavoritosContract.View favoritosView;
    private FirebaseUser user;

    public FavoritosPresenter(FavoritosFragment favoritosFragment) {
        this.favoritosView = favoritosFragment;
        user = FirebaseAuth.getInstance().getCurrentUser();
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
        final String url = " https://us-central1-hellogas-3db04.cloudfunctions.net/getfavorites?id=" + user.getUid();
        Log.d("---> FAVORITOS PR", url);
        GApiTask task = new GApiTask(this, favoritosView.getContext());
        task.request(url);
        favoritosView.loading();
    }

    @Override
    public void deleteFavorito() {

    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("favoritos");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject response = jsonArray.getJSONObject(i);
                JSONObject favoritos = response.getJSONObject(user.getUid());
                Iterator<?> keys = favoritos.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Log.d("---> Key", key);
                }

                Log.d("---> FAVORITOS PR", favoritos.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}