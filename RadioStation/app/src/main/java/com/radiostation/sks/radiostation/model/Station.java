package com.radiostation.sks.radiostation.model;

public class Station {


    private final String DRAWABLE = "drawable/";
    private String stationTitle;
    private String imageURL;

    public Station(String stationTitle, String imageURL) {
        this.stationTitle = stationTitle;
        this.imageURL = imageURL;
    }

    public String getDRAWABLE() {
        return DRAWABLE;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImageURL() {
        return DRAWABLE + imageURL;
    }


}
