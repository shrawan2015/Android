package com.playstore.sks.playstorereplicate.AppstoreModel;

public class AppStoreModel {

    private String appTitle;
    private String appSize;
    private String appImage;

    public AppStoreModel(String appTitle, String appSize, String appImage) {
        this.appTitle = appTitle;
        this.appSize = appSize;
        this.appImage = appImage;
    }

    public String getAppTitle() {
        return appTitle;
    }
    public String getAppSize() {
        return appSize;
    }
    public String getAppImage() {
        return appImage;
    }

}
