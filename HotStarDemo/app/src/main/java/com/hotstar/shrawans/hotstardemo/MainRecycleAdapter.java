package com.hotstar.shrawans.hotstardemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.SingleItemViewHolder> {

    private ArrayList<PlayStoreSectionModel> dataList;
    private Context context;
    private  RecyclerView.RecycledViewPool recycledViewPool;

    public MainRecycleAdapter(ArrayList<PlayStoreSectionModel> dataList, Context context) {

        this.dataList = dataList;
        this.context = context;

        //know more about this
        this.recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public SingleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_scroll_view ,null);
        SingleItemViewHolder itemViewHolder = new SingleItemViewHolder(v);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemViewHolder holder, int position) {
        final String sectionName = dataList.get(position).getSectionTitle();

        ArrayList singleSectionItems = dataList.get(position).getAllItemInSection();
        holder.itemTitle.setText(sectionName);
        AppStoreAdapter adapter = new AppStoreAdapter(singleSectionItems, context);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setRecycledViewPool(recycledViewPool);
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Button More Clicked!" + sectionName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }


    public class  SingleItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView itemTitle;
        protected RecyclerView recyclerView;
        protected Button btnMore;

        public SingleItemViewHolder(View itemView) {
            super(itemView);
            this.itemTitle = itemView.findViewById(R.id.itemTitle);
            this.recyclerView = itemView.findViewById(R.id.recycler_view_list);
            this.btnMore = itemView.findViewById(R.id.btnMore);
        }
    }

}
