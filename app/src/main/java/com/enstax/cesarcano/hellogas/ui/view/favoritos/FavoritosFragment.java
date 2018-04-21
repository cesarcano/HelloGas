package com.enstax.cesarcano.hellogas.ui.view.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.FavoritosPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseFragment;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by cesarcanojmz@gmail.com
 */


public class FavoritosFragment extends BaseFragment implements FavoritosContract.View {
    private ListView listView;
    private FavoritosContract.Presenter presenter;
    private FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favoritos, container, false);

        listView = view.findViewById(R.id.list_favoritos);

        presenter = new FavoritosPresenter(this);
        presenter.loadFavoritos();

        return view;
    }

    @Override
    public void loadList() {
        hideProgressDialog();
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
        Util.showMessage(getContext(), "Error");
    }
}