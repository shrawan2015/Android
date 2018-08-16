package com.playstore.sks.playstorereplicate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playstore.sks.playstorereplicate.AppstoreModel.AppStoreModel;
import com.playstore.sks.playstorereplicate.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<AppStoreModel> appStoreModel;


    public MainAdapter(List<AppStoreModel> appStoreModel) {
        this.appStoreModel = appStoreModel;
    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content_cell,parent,false);
        return new MainViewHolder(v,parent.getContext());
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        AppStoreModel movie = appStoreModel.get(position);
        holder.maintext.setText(movie.getAppTitle());


    }


    @Override
    public int getItemCount() {
        return appStoreModel.size();
    }
}
