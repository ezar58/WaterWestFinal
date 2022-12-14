package com.example.waterwestfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4

};

    int headings[] = {
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title

    };
    int descriptions[] = {
            R.string.first_slide_desc,
    R.string.second_slide_desc,
    R.string.third_slide_desc,
    R.string.fourth_slide_desc

    };


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout)object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView = view.findViewById(R.id.slidingImage);
        TextView textView = view.findViewById(R.id.slideText);
        TextView textView1 = view.findViewById(R.id.sliderlast);

        imageView.setImageResource(images[position]);
        textView.setText(headings[position]);
        textView1.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
