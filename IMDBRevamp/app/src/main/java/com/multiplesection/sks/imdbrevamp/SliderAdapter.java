package com.multiplesection.sks.imdbrevamp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context =context;

    }

    public int[] slidenotes = {
            R.drawable.bg,
            R.drawable.bg33,
            R.drawable.bg,
            R.drawable.bg33
    };

    @Override
    public int getCount() {
        return slidenotes.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

    LayoutInflater inflator = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = inflator.inflate(R.layout.slidelayout,container,false);

    ImageView imageview  = (ImageView) view.findViewById(R.id.imageView);
        imageview.setImageResource(slidenotes[position]);
        container.addView(view);
    return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((RelativeLayout)object);
    }
}
