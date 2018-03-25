package com.enstax.cesarcano.hellogas.ui.view.gasolinera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enstax.cesarcano.hellogas.R;


/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentariosGasolinera extends Fragment {


    private String idgasolinera;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_gasolinera_comentarios, container, false);
        return view;
    }

    public void setIdgasolinera(String idgasolinera) {
        this.idgasolinera = idgasolinera;
    }
}