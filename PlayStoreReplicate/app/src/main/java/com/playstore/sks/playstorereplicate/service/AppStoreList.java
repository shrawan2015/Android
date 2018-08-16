package com.playstore.sks.playstorereplicate.service;

import com.playstore.sks.playstorereplicate.AppstoreModel.AppStoreModel;

import java.util.ArrayList;

public class AppStoreList {

        private static final AppStoreList ourInstance = new AppStoreList();

        public static AppStoreList getInstance() {
            return ourInstance;
        }

        private AppStoreList() {

        }

        public ArrayList<AppStoreModel> getAllForYouApp() {
            //Pretend we just downloaded featured stations from the Internet
            ArrayList<AppStoreModel> list = new ArrayList<>();
            list.add(new AppStoreModel("Recomended for you", "12MB" ,"dummyImage"));
            list.add(new AppStoreModel("Editor Choice's App", "12MB" ,"dummyImage"));
            list.add(new AppStoreModel("Favourite for you", "12MB" ,"dummyImage"));
            list.add(new AppStoreModel("Playing for you", "12MB" ,"dummyImage"));
            list.add(new AppStoreModel("Game we are playing", "12MB" ,"dummyImage"));
            return list;
        }
    }

