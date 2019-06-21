package com.example.onborading;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    int arrImageSlider[] = {R.drawable.reunion, R.drawable.interview, R.drawable.notebook, R.drawable.address};
    String arrTitleSlider[] = {"reunion", "interview", "notebook", "Address"};
    String arrDescriptionSlider[] = {"About is Arleay reunion how are you today i am ", "interview how are you today i am ", " how are you today i am notebook", "how are you today i am  Address"};

    public SliderAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrImageSlider.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.slider_layout, container,false);
        ImageView imageSlider = (ImageView) view.findViewById(R.id.imageSlider);
        TextView titleSlider = (TextView) view.findViewById(R.id.txtTitleSlider);
        TextView descriptionSlider = (TextView) view.findViewById(R.id.txtDescriptionSlider);

        imageSlider.setImageResource(arrImageSlider[position]);
        titleSlider.setText(arrTitleSlider[position]);
        descriptionSlider.setText(arrDescriptionSlider[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
