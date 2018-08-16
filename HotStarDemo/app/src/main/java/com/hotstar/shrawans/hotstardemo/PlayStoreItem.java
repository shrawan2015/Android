package com.hotstar.shrawans.hotstardemo;

public class PlayStoreItem {

    private String name,url,description,isPremium , appSize ;



    //Why we are making this one.
    public PlayStoreItem(){

    }

    public PlayStoreItem(String name, String url, String description,String isPremium ,String appSize){
        this.description =description;
        this.isPremium = isPremium;
        this.name = name;
        this.url = url;
        this.appSize = appSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(String isPremium) {
        this.isPremium = isPremium;
    }

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize;
    }
}
