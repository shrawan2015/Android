package com.multiplesection.sks.imdbrevamp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
    private ArrayList<SingleVertical> data = new ArrayList<>();

    public VerticalAdapter(ArrayList<SingleVertical> data) {
        this.data = data;
    }

    @Override
    public VerticalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_horizontal_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VerticalAdapter.MyViewHolder holder, int position) {
       /// holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getHeader());
        holder.description.setText(data.get(position).getSubHeader());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
           /// image = (ImageView) itemView.findViewById(R.id.imageView);



//            image = (ImageView) itemView.findViewById(R.id.imageView);
//            title = (TextView) itemView.findViewById(R.id.title);
//            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}