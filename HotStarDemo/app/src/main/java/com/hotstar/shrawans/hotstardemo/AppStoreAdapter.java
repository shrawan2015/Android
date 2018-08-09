package com.hotstar.shrawans.hotstardemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppStoreAdapter  extends RecyclerView.Adapter<AppStoreAdapter.SingleItemRowHolder>{

    private ArrayList<PlayStoreItem> appModels;
    private Context context;

    public AppStoreAdapter(ArrayList<PlayStoreItem> appModels , Context context) {
        this.appModels = appModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(context).inflate(R.layout.each_app_item_cell,null);
        SingleItemRowHolder singleItemHolder = new SingleItemRowHolder(v);
        return singleItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        PlayStoreItem itemModel = appModels.get(position);
        holder.tvTitle.setText(itemModel.getName());
    }

    @Override
    public int getItemCount() {
        return  (null != appModels ? appModels.size() : 0) ;
    }


    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;

        public SingleItemRowHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.itemImage = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
