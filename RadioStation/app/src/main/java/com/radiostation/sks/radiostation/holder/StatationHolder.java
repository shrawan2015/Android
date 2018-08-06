package com.radiostation.sks.radiostation.holder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.radiostation.sks.radiostation.R;
import com.radiostation.sks.radiostation.model.Station;

public class StatationHolder  extends ViewHolder{


    private ImageView mainimage;

    private TextView textimage;

    public StatationHolder(View itemView) {
        super(itemView);
        this.mainimage = (ImageView)itemView.findViewById(R.id.main_image);
        this.textimage = (TextView)itemView.findViewById(R.id.main_text);

    }

    public  void  updateUI(Station station){
        String URI =  station.getImageURL();
        int resource =  mainimage.getResources().getIdentifier(URI,null,mainimage.getContext().getPackageName());
            mainimage.setImageResource(resource);

        String stationTitle =  station.getStationTitle();
        textimage.setText(stationTitle);
    }
}
