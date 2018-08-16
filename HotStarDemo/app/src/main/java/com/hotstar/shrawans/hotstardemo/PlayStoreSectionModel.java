package com.hotstar.shrawans.hotstardemo;

import java.util.ArrayList;

public class PlayStoreSectionModel {

    private String sectionTitle,sectionDescription;
    private ArrayList<PlayStoreItem> allItemInSection;


    //Why to create the constructor
    public PlayStoreSectionModel(){

    }

    public PlayStoreSectionModel(String sectionTitle,  String sectionDescription,  ArrayList<PlayStoreItem> allItemInSection) {
        this.allItemInSection = allItemInSection;
        this.sectionDescription = sectionDescription;
        this.sectionTitle = sectionTitle;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public ArrayList<PlayStoreItem> getAllItemInSection() {
        return allItemInSection;
    }

    public void setAllItemInSection(ArrayList<PlayStoreItem> allItemInSection) {
        this.allItemInSection = allItemInSection;
    }
}
