package com.example.comebuy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Foodone_mainFragment extends Fragment implements View.OnClickListener, Animator.AnimatorListener {
    private ValueAnimator mShowAction;
    private ValueAnimator mHideAction;
    private LinearLayout shoppingall;
    private int measuredHeight;
    private ImageView food_add ;
    int texttotal;
    private CustomView customView;
    private boolean isShow = true;
    private ArrayList<Food> foodlist= new ArrayList<>();
    private TextView    total;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.foodone_mainfragment,container,false);
        Foodin();
        food_add = view.findViewById(R.id.add);
        total = view.findViewById(R.id.total);
        CustomView customView = view.findViewById(R.id.customView);
        Button btnshow = view.findViewById(R.id.testbutton_show);
        Button btnhide = view.findViewById(R.id.testbutton_hide);
        btnshow.setOnClickListener(this);
        btnhide.setOnClickListener(this);
        shoppingall = customView.findViewById(R.id.shoppall);
//        customView.setVisibility(View.GONE);
//        shoppingall.setVisibility(View.GONE);
        shoppingall.post(new Runnable() {
            @Override
            public void run() {
                measuredHeight = shoppingall.getMeasuredHeight();
                mShowAction = ValueAnimator.ofInt(0, measuredHeight);
                mHideAction = ValueAnimator.ofInt(measuredHeight,0);
                mShowAction.addListener(Foodone_mainFragment.this);
                mHideAction.addListener(Foodone_mainFragment.this);
            }
        });
        ListView self_food_listview = view.findViewById(R.id.self_food);
        FoodAdapter adapter1 = new FoodAdapter(getActivity(),R.layout.self_food,foodlist);
        self_food_listview.setAdapter(adapter1);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.testbutton_show:
                if (!isShow) {
                    shoppingall.setVisibility(View.VISIBLE);
                    mShowAction.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            shoppingall.getLayoutParams().height = (int) animation.getAnimatedValue();
                            shoppingall.requestLayout();
                        }
                    });
                    isShow = true;
                    mShowAction.setDuration(900);
                    mShowAction.start();
                }
                break;
            case R.id.testbutton_hide:
                if (isShow) {
//                    shoppingall.setVisibility(View.GONE);
                    mHideAction.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            shoppingall.getLayoutParams().height = (int) animation.getAnimatedValue();
                            shoppingall.requestLayout();
                        }
                    });
                    isShow = false;
                    mHideAction.setDuration(900);
                    mHideAction.start();
                }
                break;
        }
    }
    private void Foodin(){
        Food one = new Food("千珏老婆",R.drawable.qianjue,"摘下面具巨好康","1","1100"
                ,R.drawable.add,R.drawable.reduce,"0"
        );
        foodlist.add(one);

        Food tow = new Food("蛇女老婆",R.drawable.shenv,"巨性感","1","100"
                ,R.drawable.add,R.drawable.reduce,"0");
        foodlist.add(tow);

    }
    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {

    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
