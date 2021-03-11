package com.example.comebuy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by 张思远 on 2020/12/13.
 */

public class MainFragment extends Fragment implements Animator.AnimatorListener/*,View.OnClickListener */{
    private ArrayList<kinds> list = new ArrayList<kinds>();
    private ArrayList<Food> foodlist= new ArrayList<>();
    private ImageView food_add ;
    int texttotal;
    private boolean isShow = true;
    private ValueAnimator mShowAction;
    private ValueAnimator mHideAction;
    private LinearLayout shoppingall;
    private int measuredHeight;
    private CustomView customView;
    private ArrayList<Fragment>fragments = new ArrayList<>();
    private TextView    total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        intitKinds();
        addFragment();
        replaceFragemt(fragments.get(0));
        View view = inflater.inflate(R.layout.main_shopping, container, false);
        Button button_position = view.findViewById(R.id.button_position);
        Drawable position = getResources().getDrawable(R.drawable.position);
        position.setBounds(15,0,45,30);
        button_position.setCompoundDrawables(position,null,null,null);
//        food_add = view.findViewById(R.id.add);
//        total = view.findViewById(R.id.total);
//        CustomView customView = view.findViewById(R.id.customView);
//        Button btnshow = view.findViewById(R.id.testbutton_show);
//        Button btnhide = view.findViewById(R.id.testbutton_hide);
//        btnshow.setOnClickListener(this);
//        btnhide.setOnClickListener(this);
//        shoppingall = customView.findViewById(R.id.shoppall);
////        customView.setVisibility(View.GONE);
////        shoppingall.setVisibility(View.GONE);
//        shoppingall.post(new Runnable() {
//            @Override
//            public void run() {
//                measuredHeight = shoppingall.getMeasuredHeight();
//                mShowAction = ValueAnimator.ofInt(0, measuredHeight);
//                mHideAction = ValueAnimator.ofInt(measuredHeight,0);
//                mShowAction.addListener(MainFragment.this);
//                mHideAction.addListener(MainFragment.this);
//            }
//        });
        final ListView listView = (ListView) view.findViewById(R.id.kinds);
//        ListView self_food_listview = view.findViewById(R.id.self_food);
        KindsAdapter adapter = new KindsAdapter(getActivity(),R.layout.kindsitem,list);
        listView.setAdapter(adapter);
//        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                kinds Kind = list.get(position){
//
//
//                }//这个用集合把你要的碎片放进去，然后根据position去找哪个碎片。
//         }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            kinds kind = list.get(position);
            Foodin();
            for(int i = 0;i<=position;i++){
                if (position == i){
                    replaceFragemt(fragments.get(position+1));
//                FoodAdapter adapter1 = new FoodAdapter(getActivity(),R.layout.self_food,foodlist);
//                self_food_listview.setAdapter(adapter1);

//                food_add.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        texttotal = Integer.parseInt(total.getText().toString());
//                        texttotal+=1;
//                        total.setText(texttotal);
//                    }
//                });
                }
            }
            }
        });

        return view;
    }
    public void addFragment(){
        fragments.add(new Show_mainFragment());
        fragments.add(new Foodone_mainFragment());

    }
    private void  replaceFragemt(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.exchangeFragment,fragment);
        transaction.commit();
    }



    private void intitKinds(){
            kinds ktv = new kinds(R.drawable.ktv, "KTV");
            list.add(ktv);
            kinds food = new kinds(R.drawable.food, "美食");
            list.add(food);
            kinds movie = new kinds(R.drawable.movie, "电影");
            list.add(movie);
            kinds look = new kinds(R.drawable.look, "景区");
            list.add(look);
            kinds hotle = new kinds(R.drawable.hotle, "酒店");
            list.add(hotle);
            kinds train = new kinds(R.drawable.train, "火车表");
            list.add(train);
            kinds medicine = new kinds(R.drawable.medicine, "买药");
            list.add(medicine);
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
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.testbutton_show:
//                if (!isShow) {
//                    shoppingall.setVisibility(View.VISIBLE);
//                    mShowAction.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            shoppingall.getLayoutParams().height = (int) animation.getAnimatedValue();
//                            shoppingall.requestLayout();
//                        }
//                    });
//                    isShow = true;
//                    mShowAction.setDuration(900);
//                    mShowAction.start();
//                }
//                break;
//            case R.id.testbutton_hide:
//                if (isShow) {
////                    shoppingall.setVisibility(View.GONE);
//                    mHideAction.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            shoppingall.getLayoutParams().height = (int) animation.getAnimatedValue();
//                            shoppingall.requestLayout();
//                        }
//                    });
//                    isShow = false;
//                    mHideAction.setDuration(900);
//                    mHideAction.start();
//                }
//                break;
//        }
//    }

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
