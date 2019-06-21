package com.example.onborading;

import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ViewPager Slider;
    LinearLayout DotsSlider;

    SliderAdapter sliderAdapter;

    TextView[] Dots;

    Button btnSkip;
    ImageView imgNext;
    ImageView imgPrev;

    int mCurrent=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slider = (ViewPager) findViewById(R.id.SliderViewPager);
        DotsSlider = (LinearLayout) findViewById(R.id.DotSlider);
        btnSkip=(Button) findViewById(R.id.btnSkip);
        imgNext=(ImageView) findViewById(R.id.imgNext);
        imgPrev=(ImageView) findViewById(R.id.imgPrev);


        sliderAdapter = new SliderAdapter(this);
        Slider.setAdapter(sliderAdapter);
        Slider.addOnPageChangeListener(this);


        AddDots(0);
        imgPrev.setVisibility(View.INVISIBLE);


        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slider.setCurrentItem(mCurrent+1);
            }
        });
        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slider.setCurrentItem(mCurrent-1);
            }
        });

    }

    void AddDots(int position) {

        Dots = new TextView[4];
        DotsSlider.removeAllViews();

        for (int i = 0; i < Dots.length; i++) {
            Dots[i] = new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226"));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            DotsSlider.addView(Dots[i]);
        }

        if (Dots.length > 0) {
            Dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

        AddDots(i);
        mCurrent=i;

        if(mCurrent==0){
            imgPrev.setVisibility(View.INVISIBLE);
            imgNext.setVisibility(View.VISIBLE);
        }else if (mCurrent==Dots.length-1){
            imgNext.setVisibility(View.INVISIBLE);


            imgPrev.setVisibility(View.VISIBLE);
        }else{
            imgPrev.setVisibility(View.VISIBLE);
            imgNext.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
