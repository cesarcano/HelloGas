package com.enstax.cesarcano.hellogas.ui.view.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseFragment;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesarcanojmz@gmail.com
 */


public class FavoritosFragment extends BaseFragment implements FavoritosContract.View {
    private ListView listView;
    private FavoritosContract.Presenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favoritos, container, false);

        listView = view.findViewById(R.id.list_favoritos);

        //presenter.loadFavoritos();

        return view;
    }

    @Override
    public void loadList() {
    }

    @Override
    public void setUser(FirebaseUser user) {

    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }
}