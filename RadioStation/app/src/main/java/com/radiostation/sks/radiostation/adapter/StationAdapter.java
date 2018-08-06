package com.radiostation.sks.radiostation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radiostation.sks.radiostation.R;
import com.radiostation.sks.radiostation.activity.MainActivity;
import com.radiostation.sks.radiostation.holder.StatationHolder;
import com.radiostation.sks.radiostation.model.Station;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StatationHolder> {  //expecting the viewholder


    private ArrayList<Station> stations;

    public StationAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StatationHolder holder, final int position) {


        final Station station  = stations.get(position);

        holder.updateUI(station);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadScreen(station);
            }
        });

//        final int p =
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public StatationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout ,parent,false);



        return  new StatationHolder(stationCard);

    }
}
