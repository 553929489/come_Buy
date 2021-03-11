package com.example.comebuy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private int resourceId;
    int texttotal;
    double muchall;
    int mm;
    List<Double> list_total = new ArrayList<>();
    double[] doubles = new double[2];


    public FoodAdapter(@NonNull Context context, int resourceId, @NonNull List<Food> foodList) {
        super(context, resourceId, foodList);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Food food = getItem(position);
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder  = new ViewHolder();
            viewHolder.Food_im = view.findViewById(R.id.food_image);
            viewHolder.Food_name = view.findViewById(R.id.food_name);
            viewHolder.Food_moth_much = view.findViewById(R.id.month_much);
            viewHolder.Food_introduction = view.findViewById(R.id.introduction);
            viewHolder.Food_price = view.findViewById(R.id.Price);
            viewHolder.Food_add = view.findViewById(R.id.add);
            viewHolder.Food_reduce = view.findViewById(R.id.reduce);
            viewHolder.total = view.findViewById(R.id.total);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.Food_name.setText(food.getFood_name());
        viewHolder.Food_im.setImageResource(food.getFood_image());
        viewHolder.Food_price.setText(food.getFood_price());
        viewHolder.Food_moth_much.setText(food.getFood_month_much());
        viewHolder.Food_introduction.setText(food.getFood_introduction());
        viewHolder.Food_add.setImageResource(food.getFood_add());
        viewHolder.Food_reduce.setImageResource(food.getFood_reduce());
        viewHolder.total.setText(food.getTotal());
        viewHolder.Food_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texttotal = Integer.parseInt(viewHolder.total.getText().toString());
                texttotal+=1;
                viewHolder.total.setText(String.valueOf(texttotal));
                muchall += Integer.parseInt(viewHolder.Food_price.getText().toString());
                mm +=1;
                list_total.add((double) mm);
                list_total.add(muchall);
                Log.d("fky", String.valueOf(mm));
                Log.d("fk", String.valueOf(muchall));
//                doubles[0] = mm;
//                doubles[1] = muchall;
            }
        });
        viewHolder.Food_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texttotal = Integer.parseInt(viewHolder.total.getText().toString());
//                if (texttotal==0){
//                    texttotal =0;
//                    viewHolder.total.setText(String.valueOf(texttotal));
//                    muchall -= Integer.parseInt(viewHolder.Food_price.getText().toString());
//                    Log.d("fky", String.valueOf(mm));
//                    Log.d("fk", "0");
//                }else {
//                    texttotal-=1;
//                    viewHolder.total.setText(String.valueOf(texttotal));
//                    muchall -= Integer.parseInt(viewHolder.Food_price.getText().toString());
//                    mm -=1;
//                    Log.d("fky", String.valueOf(mm));
//                    Log.d("fk", String.valueOf(muchall));
//
//                }
                if (mm==0){
                    muchall = 0;
                    Log.d("fky", String.valueOf(mm));
                    Log.d("fk", String.valueOf(muchall));
//                    list_total.add((double) mm);
//                    list_total.add(muchall);
//                    doubles[0] = mm;
//                    doubles[1] = muchall;
                }else {
                    if (texttotal ==0){
                        texttotal =0;
                        viewHolder.total.setText(String.valueOf(texttotal));
                        muchall = muchall;
                        Log.d("fky", String.valueOf(mm));
                        Log.d("fk", String.valueOf(muchall));
//                        list_total.add((double) mm);
//                        list_total.add(muchall);
//                        doubles[0] = mm;
//                        doubles[1] = muchall;
                    }
                    else {
                        texttotal-=1;
                        viewHolder.total.setText(String.valueOf(texttotal));
                        muchall -= Integer.parseInt(viewHolder.Food_price.getText().toString());
                        mm -=1;
                        Log.d("fky", String.valueOf(mm));
                        Log.d("fk", String.valueOf(muchall));
//                        list_total.add((double) mm);
//                        list_total.add(muchall);
//                        doubles[0] = mm;
//                        doubles[1] = muchall;

                    }
                }

            }
        });
        if (doubles.length==0){
            Log.d("haha", "getView: null");
        }else{
            Log.d("mdf", String.valueOf(doubles[0]));
            Log.d("md", String.valueOf(doubles[1]));
        }

        return view;
    }

    class ViewHolder{
        TextView Food_introduction;
        ImageView Food_im;
        TextView Food_name;
        TextView Food_price;
        TextView Food_moth_much;
        ImageView Food_add;
        ImageView Food_reduce;
        TextView total;
    }
    private Animation getShowAnimation(){
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotate = new RotateAnimation(0,720,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        set.addAnimation(rotate);
        TranslateAnimation translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,2f
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        set.addAnimation(translate);
        AlphaAnimation alpha = new AlphaAnimation(0,1);
        set.addAnimation(alpha);
        set.setDuration(500);
        return set;
    }
    //隐藏减号的动画
    private Animation getHiddenAnimation(){
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotate = new RotateAnimation(0,720,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        set.addAnimation(rotate);
        TranslateAnimation translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,2f
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        set.addAnimation(translate);
        AlphaAnimation alpha = new AlphaAnimation(1,0);
        set.addAnimation(alpha);
        set.setDuration(500);
        return set;
    }
public interface  A {
    void  onClick(int a, int b);
}

    A a;

    public void setListen (A a) {
        this.a = a;
    }

//    public void A (int a, int b) {
//        if (a != null) {
//
//        }
//    }


}
