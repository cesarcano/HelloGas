package com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.GasolineraPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.TabFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.enstax.cesarcano.hellogas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class DetalleGasolinera extends TabFragment implements DetalleGasContract.View {
    // InfoGas
    private String idgasolinera;
    private GoogleMap map;
    private Gasolinera gasolinera;

    private DetalleGasContract.Presenter presenter;

    @BindView(R.id.tv_marca) TextView tv_marca;
    @BindView(R.id.tv_direccion) TextView tv_direccion;
    @BindView(R.id.tv_calificacion) TextView tv_calificacion;
    @BindView(R.id.tv_distancia) TextView tv_distancia;
    @BindView(R.id.rating_lugar) RatingBar ratingBar;
    @BindView(R.id.iv_favorite) ImageView iv_FavoriteGas;
    @BindView(R.id.iv_atm) ImageView iv_atm;
    @BindView(R.id.iv_wc) ImageView iv_wc;
    @BindView(R.id.iv_shop) ImageView iv_shop;
    @BindView(R.id.ll_atm) LinearLayout ll_atm;
    @BindView(R.id.ll_wc) LinearLayout ll_wc;
    @BindView(R.id.ll_shop) LinearLayout ll_shop;
    @BindView(R.id.iv_comollegar) LinearLayout iv_como;
    @BindView(R.id.mapView) MapView mapView;

    private final float DEFAULT_ZOOM = (float) 14.5;

    private final float DEFAULT_RATING_SERVICE = (float) 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_gasolinera_detalle, container, false);

        ButterKnife.bind(this, view);

        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        presenter = new GasolineraPresenter(this, getContext());
        presenter.attachView(this);
        presenter.getInfo(idgasolinera);
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng location;
                try {
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    map.getUiSettings().setCompassEnabled(true);
                    map.getUiSettings().setAllGesturesEnabled(false);
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED) {
                        location = new LatLng(gasolinera.getPosicion().getLatitud(), gasolinera.getPosicion().getLongitud());
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, DEFAULT_ZOOM));
                        map.addMarker(new MarkerOptions().position(location));
                        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                return true;
                            }
                        });
                    }
                } catch (Exception e) {
                    Log.e("Error Location", e.getLocalizedMessage());
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, final float rating, boolean fromUser) {
                new AlertDialog.Builder(getContext())
                        .setMessage("¿Desea calificar esta gasolinera?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                addComentario(rating);
                            }
                        })
                        .setNegativeButton("No", null)
                        .create()
                        .show();
            }
        });

        return view;
    }


    private void addComentario(float rating) {
    }

    public void setIdgasolinera(String idgasolinera) {
        this.idgasolinera = idgasolinera;
    }

    @OnClick(R.id.iv_comollegar)
    public void comoLlegar(){
        Uri uri;
        double lat = gasolinera.getPosicion().getLatitud();
        double lon = gasolinera.getPosicion().getLongitud();
        if(lat != 0 || lon != 0 ) {
            uri = Uri.parse("geo:" + lat + "," + lon);
        } else {
            uri = Uri.parse("geo:0,0?q="+gasolinera.getDomicilio());
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
    }

    @Override
    public void loadInfo(Gasolinera gasolinera) {
        hideProgressDialog();
    }

    @Override
    public void heart() {
        hideProgressDialog();
    }
}