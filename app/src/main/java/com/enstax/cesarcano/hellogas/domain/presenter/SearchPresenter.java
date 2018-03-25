package com.enstax.cesarcano.hellogas.domain.presenter;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.view.search.SearchContract;
import com.enstax.cesarcano.hellogas.ui.view.search.SearchFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SearchPresenter implements SearchContract.Presenter, WebTask.Presenter {

    private SearchContract.View view;

    private ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();

    public SearchPresenter(SearchFragment searchFragment) {
        this.view = searchFragment;
    }

    @Override
    public void attachView(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPlacesInThisArea(Double lat, Double lng) {
        final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
        final String RADIUS = "&radius=";
        final String TYPE = "&type=gas_station";
        final String KEY = "&key=AIzaSyAoeIJWYdCLDklb4dTlCD2-MFAtOtctCsY";
        view.loading();
        GApiTask gapi = new GApiTask(this, view.getContext());
        gapi.request(BASE_URL + lat + "," + lng + RADIUS + 5000 + TYPE + KEY);
    }

    @Override
    public void getPlaceInfo(String id) {
        view.loading();
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jPlaceObj = jsonArray.getJSONObject(i);
                JSONObject jGeometry = jPlaceObj.getJSONObject("geometry");
                JSONObject jLocation = jGeometry.getJSONObject("location");
                Double latitud = jLocation.getDouble("lat");
                Double longitud = jLocation.getDouble("lng");
                String id = jPlaceObj.getString("place_id");
                String domicilio = jPlaceObj.getString("vicinity");
                String marca = jPlaceObj.getString("name");

                Gasolinera gasolinera = new Gasolinera(id, marca, domicilio, latitud, longitud);

                gasolineras.add(gasolinera);
                //HgFirebaseDB hgFirebaseDB = new HgFirebaseDB();
                //hgFirebaseDB.createGasStation(id, marca, domicilio, latitud, longitud);
            }

            view.loadPlaces(gasolineras);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}