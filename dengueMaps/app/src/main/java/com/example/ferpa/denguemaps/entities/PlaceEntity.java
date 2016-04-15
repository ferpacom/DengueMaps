package com.example.ferpa.denguemaps.entities;

import java.io.Serializable;

/**
 * Created by Ferpa on 11/04/2016.
 */
public class PlaceEntity implements Serializable {

    private double lat;
    private double lng;

    public PlaceEntity() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
