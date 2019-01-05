package com.example.mink.tutorial9;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adapter extends PagerAdapter {

    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length; //이미지 개수
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);      //object 를 LinearLayout으로 형 변환했을 때 view와 같은가
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        imageView.setImageResource(images[position]);
        textView.setText((position+1) + "번째 이미지입니다.");
        container.addView(v);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();
    }
}
