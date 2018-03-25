package com.enstax.cesarcano.hellogas.ui.view.cercanas;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.CercanasPresenter;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.adapter.ListGasolineras;
import com.enstax.cesarcano.hellogas.ui.helper.BottomNavigationViewHelper;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseFragment;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class CercanasFragment extends BaseFragment implements CercanasContract.View{

    @BindView(R.id.list)
    ListView list_Cercanas;

    private CercanasContract.Presenter presenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filtro_precio:
                    presenter.loadByPrice();
                    return true;
                case R.id.filtro_mascerca:
                    //presenter.loadByDistance();
                    return true;
                case R.id.filtro_valoracion:
                    //presenter.loadByValoration();
                    return true;
                case R.id.filtro_promo:
                    //presenter.loadByPromo();
                    return true;
            }
            return false;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Se inicia la comunicación con el Presentador
        View view =  inflater.inflate(R.layout.fragment_cercanas, container, false);

        presenter = new CercanasPresenter(this);

        BottomNavigationView navigation = view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setSelectedItemId(R.id.filtro_precio);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnItemClick(R.id.list)
    void onItemClick(int position) {
        Toast.makeText(getActivity(), "CLICK EN ITEM " + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void loadList(ArrayList<Gasolinera> gasolineras) {
        for (Gasolinera gasolinera: gasolineras) {
            Log.d("loadList: ", gasolinera.toString());
        }
        /*
        ListGasolineras adapter = new ListGasolineras(getContext(), gasolineras);
        list_Cercanas.setAdapter(adapter);
        */
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {

    }
}