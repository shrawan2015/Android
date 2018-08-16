package com.playstore.sks.playstorereplicate.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.playstore.sks.playstorereplicate.R;
import com.playstore.sks.playstorereplicate.service.AppStoreList;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView maintext;
    String appname;
    RecyclerView second_recycle_view;
    Context context;


    public MainViewHolder(View itemView,Context context) {
        super(itemView);
        this.context =  context;

        maintext = (TextView)itemView.findViewById(R.id.maintextview);
        second_recycle_view =  (RecyclerView)itemView.findViewById(R.id.custom_recycle_view);

        second_recycle_view.setHasFixedSize(true);
        second_recycle_view.setAdapter(new MainAdapter(AppStoreList.getInstance().getAllForYouApp()));

        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        second_recycle_view.setLayoutManager(linearLayoutManager);
    }
}
