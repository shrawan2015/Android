package com.multiplesection.sks.imdbrevamp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linearLayout;
    TextView centerDot;
    SliderAdapter sliderAdapter;
    TextView[] mdots;
    Button nextButton;
    Button previousButton;
    Integer positionOfPage;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }


        setContentView(R.layout.activity_main);
        positionOfPage = 0;
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);

        nextButton = (Button) findViewById(R.id.nextButton);
        previousButton = (Button)findViewById(R.id.previousButton);


        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
//        centerDot = (TextView) findViewById(R.id.centerDot);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addDotsIndicator(positionOfPage + 1);

                if ( positionOfPage + 1 == mdots.length ) {
                    prefManager.setFirstTimeLaunch(false);
                    launchHomeScreen();
                }else{
                    viewPager.setCurrentItem(positionOfPage + 1);
                }

            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(positionOfPage - 1);
            }
        });


    }


    public  void launchHomeScreen(){
        finish();

        startActivity(new Intent(MainActivity.this, HomePage.class));

    }


    public void addDotsIndicator(int position) {
        mdots = new TextView[3];
        linearLayout.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorWhiteTransparent));
            linearLayout.addView(mdots[i]);


        }

        if (mdots.length > 0) {
            mdots[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            positionOfPage = position;

            if ( position == 0) {
                nextButton.setEnabled(true);
                previousButton.setEnabled(false);
                previousButton.setVisibility(View.INVISIBLE);
                nextButton.setText("Next");
                previousButton.setText("");

            }else if (position == mdots.length - 1 ){
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("Finish");
                previousButton.setText("Back");
            }else{
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("Next");
                previousButton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };


}
