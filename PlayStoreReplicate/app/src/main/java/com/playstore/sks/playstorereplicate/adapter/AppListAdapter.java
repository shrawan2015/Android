package com.playstore.sks.playstorereplicate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playstore.sks.playstorereplicate.AppstoreModel.AppStoreModel;
import com.playstore.sks.playstorereplicate.R;

import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListViewHolder> {
    private List<AppStoreModel> appStoreModel;


    public AppListAdapter(List<AppStoreModel> appStoreModel) {
        this.appStoreModel = appStoreModel;
    }


    @Override
    public AppListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.applist_layout_content_cell,parent,false);
        return new AppListViewHolder(v,parent.getContext());
    }

    @Override
    public void onBindViewHolder(AppListViewHolder holder, int position) {
        AppStoreModel movie = appStoreModel.get(position);
        holder.maintext.setText(movie.getAppTitle());
    }

    @Override
    public int getItemCount() {
        return appStoreModel.size();
    }
}