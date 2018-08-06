package com.radiostation.sks.radiostation.fragment;


import android.graphics.Rect;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radiostation.sks.radiostation.R;
import com.radiostation.sks.radiostation.adapter.StationAdapter;
import com.radiostation.sks.radiostation.services.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    private static final String ARG_STATION_TYPE = "STATIONTYPE";

    // TODO: Rename and change types of parameters


    private int stationType;


    public static final  int STATION_TYPE_FEATURED = 0;
    public static final  int STATION_TYPE_RECENT = 1;
    public static final  int STATION_TYPE_PARTY = 2;



    public StationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType Parameter 1.
     * @return A new instance of fragment StationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationFragment newInstance(int stationType) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE,stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_station, container, false);

        RecyclerView recyclerView =  (RecyclerView)v.findViewById(R.id.recycle_station);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));


        StationAdapter adapter;
        if (stationType == STATION_TYPE_FEATURED){
            adapter = new StationAdapter(DataServices.getInstance().getFeaturedStations());

        }else if (stationType == STATION_TYPE_PARTY) {
            adapter = new StationAdapter(DataServices.getInstance().getFeaturedStations());

        }else {
            adapter = new StationAdapter(DataServices.getInstance().getFeaturedStations());
        }

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return v;
    }

}


class HorizontalSpaceItemDecorator extends  RecyclerView.ItemDecoration{
    private  final int space;


    public HorizontalSpaceItemDecorator(int spacer){
        this.space = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = space ;
        outRect.bottom = space;
    }
}