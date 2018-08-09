package com.hotstar.shrawans.hotstardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PlayStoreSectionModel> allSampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allSampleData = new ArrayList<>();

        createDummyData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        MainRecycleAdapter adapter = new MainRecycleAdapter(allSampleData, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);


    }

    private void createDummyData() {
        for (int i = 1; i <= 20; i++) {
            PlayStoreSectionModel dm = new PlayStoreSectionModel();
            dm.setSectionTitle("Section " + i);
            ArrayList<PlayStoreItem> singleItemModels = new ArrayList<>();
            for (int j = 1; j <= 20; j++) {
                singleItemModels.add(new PlayStoreItem("Item " + j, "URL " + j ,"URL " + j ,"URL " + j ,"URL " + j ));
            }
            dm.setAllItemInSection(singleItemModels);
            allSampleData.add(dm);
        }

    }


}
